package com.intellij.plugins.thrift.config.facet;

import com.intellij.facet.FacetConfiguration;
import com.intellij.facet.ui.FacetEditorContext;
import com.intellij.facet.ui.FacetEditorTab;
import com.intellij.facet.ui.FacetValidatorsManager;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.ui.popup.ListPopup;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.plugins.thrift.GeneratorIcons;
import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.config.ThriftCompilerOptions;
import com.intellij.plugins.thrift.config.facet.options.OptionsDialogWrapper;
import com.intellij.plugins.thrift.config.target.Generator;
import com.intellij.plugins.thrift.config.target.GeneratorType;
import com.intellij.ui.*;
import com.intellij.ui.popup.PopupFactoryImpl;
import com.intellij.util.ui.UIUtil;
import org.apache.commons.lang.NotImplementedException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 27.06.2014 10:39
 *
 * @author xBlackCat
 */
@State(
  name = "ThriftFacetConfiguration",
  storages = {
    @Storage("$MODULE_FILE$")
  }
)
public class ThriftFacetConf implements FacetConfiguration, PersistentStateComponent<ThriftCompilerOptions> {
  private ThriftCompilerOptions config = new ThriftCompilerOptions();

  @Override
  public FacetEditorTab[] createEditorTabs(FacetEditorContext editorContext, FacetValidatorsManager validatorsManager) {
    return new FacetEditorTab[]{new ThriftFacetEditor(editorContext, validatorsManager)};
  }

  @Nullable
  @Override
  public ThriftCompilerOptions getState() {
    return config;
  }

  @Override
  public void loadState(@NotNull ThriftCompilerOptions state) {
    config = state;
  }

  private class ThriftFacetEditor extends FacetEditorTab {
    private final FacetEditorContext myContext;

    private final JComponent pane;

    private final JCheckBox cleanOnBuildCheckBox = new JCheckBox();
    private final AddEditRemovePanel<Generator> translators;
    private final AddEditRemovePanel<VirtualFile> includesList;
    private boolean modified = false;


    public ThriftFacetEditor(FacetEditorContext context,
                             FacetValidatorsManager manager) {
      myContext = context;

      cleanOnBuildCheckBox.setText(ThriftBundle.message("thrift.facet.options.clean-output"));
      cleanOnBuildCheckBox.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
          setModified();
        }
      });

      pane = new JPanel(new BorderLayout());
      pane.setBorder(IdeBorderFactory.createTitledBorder(ThriftBundle.message("thrift.facet.options.border-title"), false));

      pane.add(cleanOnBuildCheckBox, BorderLayout.NORTH);

      final JPanel central = new JPanel(new GridLayout(2, 1));
      translators = new GeneratorListPanel();
      includesList = new IncludesPanel();

      central.add(translators);
      central.add(includesList);

      pane.add(central, BorderLayout.CENTER);
    }

    @Nls
    @Override
    public String getDisplayName() {
      return ThriftFacet.DISPLAY_NAME;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
      reset();
      return pane;
    }

    @Override
    public boolean isModified() {
      return modified;
    }

    @Override
    public void reset() {
      final List<Generator> list = translators.getData();
      list.clear();
      try {
        for (Generator g : config.getGenerators()) {
          list.add(g.clone());
        }
      }
      catch (CloneNotSupportedException e) {
        throw new RuntimeException("Failed to clone generator settings");
      }

      final List<VirtualFile> includes = includesList.getData();
      includes.clear();
      for (String inc : config.getIncludes()) {
        includes.add(VirtualFileManager.getInstance().findFileByUrl(inc));
      }

      cleanOnBuildCheckBox.setSelected(config.isCleanOutput());
      modified = false;
    }

    public void setModified() {
      modified = true;
    }

    private ThriftCompilerOptions getConfig() {
      final ThriftCompilerOptions options = new ThriftCompilerOptions();
      options.getGenerators().addAll(translators.getData());
      final List<String> includes = options.getIncludes();
      for (VirtualFile vf : includesList.getData()) {
        includes.add(vf.getPath());
      }
      options.setCleanOutput(cleanOnBuildCheckBox.isSelected());

      return options;
    }

    @Override
    public void apply() throws ConfigurationException {
      config = getConfig();
      modified = false;
    }

    @Override
    public void disposeUIResources() {

    }

    private class IncludesPanel extends AddEditRemovePanel<VirtualFile> {
      public IncludesPanel() {
        super(new IncludesTableModel(), new ArrayList<VirtualFile>(),
              ThriftBundle.message("thrift.facet.options.generators.inc-list.title"));
      }

      @Nullable
      @Override
      protected VirtualFile addItem() {
        return editItem(null);
      }

      @Override
      protected boolean removeItem(VirtualFile o) {
        setModified();
        return true;
      }

      @Nullable
      @Override
      protected VirtualFile editItem(VirtualFile selected) {
        VirtualFile file = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFolderDescriptor(), this,
                                                  myContext.getProject(), selected);
        if (file == null) {
          return null;
        }
        else {
          setModified();
          return file;
        }
      }
    }

    private class GeneratorListPanel extends AddEditRemovePanel<Generator> {
      public GeneratorListPanel() {
        super(new GeneratorTableModel(), new ArrayList<Generator>(),
              ThriftBundle.message("thrift.facet.options.generators.gen-list.title"));

        setRenderer(0, new ColoredTableCellRenderer() {
          @Override
          protected void customizeCellRenderer(JTable table, Object value, boolean selected, boolean hasFocus, int row, int column) {
            assert value != null;

            GeneratorType type = (GeneratorType)value;
            setIcon(GeneratorIcons.getIcon(type));
            append(type.name(), SimpleTextAttributes.REGULAR_ATTRIBUTES);
          }
        });
        setRenderer(1, new ColoredTableCellRenderer() {
          @Override
          protected void customizeCellRenderer(JTable table, Object value, boolean selected, boolean hasFocus, int row, int column) {
            append(VfsUtil.urlToPath(value.toString()), SimpleTextAttributes.REGULAR_ATTRIBUTES);
          }
        });

        getTable().setShowColumns(true);
      }

      @Override
      protected void initPanel() {
        setLayout(new BorderLayout());

        final JPanel panel = ToolbarDecorator.createDecorator(getTable())
          .setAddAction(
            new AnActionButtonRunnable() {

              private final ActionGroup myGeneratorListGroup = new GeneratorListGroup();

              @Override
              public void run(AnActionButton button) {
                final ListPopup popup = PopupFactoryImpl.getInstance().createActionGroupPopup(
                  ThriftBundle.message("thrift.facet.options.generators.popup.title"),
                  myGeneratorListGroup,
                  button.getDataContext(),
                  JBPopupFactory.ActionSelectionAid.SPEEDSEARCH,
                  true
                );

                popup.show(button.getPreferredPopupPoint());
              }
            }
          )
          .setRemoveAction(new AnActionButtonRunnable() {
            @Override
            public void run(AnActionButton button) {
              doRemove();
            }
          })
          .setEditAction(new AnActionButtonRunnable() {
            @Override
            public void run(AnActionButton button) {
              if (getTable().isEditing()) {
                getTable().getCellEditor().stopCellEditing();
                return;
              }
              doEdit();
            }
          })
          .disableUpAction()
          .disableDownAction()
          .createPanel();
        add(panel, BorderLayout.CENTER);
        final String label = getLabelText();
        if (label != null) {
          UIUtil.addBorder(panel, IdeBorderFactory.createTitledBorder(label, false));
        }
      }

      @Nullable
      @Override
      protected Generator addItem() {
        throw new NotImplementedException("Should not be invoked");
      }

      @Override
      protected boolean removeItem(Generator o) {
        setModified();
        return true;
      }

      @Nullable
      @Override
      protected Generator editItem(Generator o) {
        Generator m = showGeneratorEditor(o);

        if (m == null) {
          return null;
        }
        else {
          setModified();
          return m;
        }
      }

      private Generator showGeneratorEditor(final Generator o) {
        final OptionsDialogWrapper dialog = new OptionsDialogWrapper(myContext.getProject(), o);
        dialog.show();

        return dialog.getModifiedObject();
      }

      private class CreateGeneratorAction extends AnAction {
        private final GeneratorType myType;

        public CreateGeneratorAction(GeneratorType type) {
          super(type.name(), "", GeneratorIcons.getIcon(type));
          myType = type;
        }

        @Override
        public void actionPerformed(AnActionEvent e) {
          final Generator o = editItem(myType.create());
          if (o == null) return;

          getData().add(o);
          int index = getData().size() - 1;
          ((AbstractTableModel)getTable().getModel()).fireTableRowsInserted(index, index);
          getTable().setRowSelectionInterval(index, index);
        }
      }

      private class GeneratorListGroup extends ActionGroup {
        private final AnAction[] actions;

        {
          final GeneratorType[] types = GeneratorType.values();
          actions = new AnAction[types.length];
          int i = 0;
          while (i < types.length) {
            actions[i] = new CreateGeneratorAction(types[i]);
            i++;
          }
        }

        @NotNull
        @Override
        public AnAction[] getChildren(@Nullable AnActionEvent e) {
          return actions;
        }
      }
    }
  }
}
