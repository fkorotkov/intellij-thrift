/*
 * Copyright 2000-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.plugins.thrift.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.plugins.thrift.lang.lexer.ThriftLexer;
import com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypeSets;
import com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes;
import com.intellij.plugins.thrift.lang.psi.ThriftFile;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

public class ThriftParserDefinition implements ParserDefinition {
  @NotNull
  public Lexer createLexer(Project project) {
    return new ThriftLexer();
  }

  public PsiParser createParser(Project project) {
    return new ThriftParser();
  }

  public IFileElementType getFileNodeType() {
    return ThriftTokenTypeSets.THRIFT_FILE;
  }

  @NotNull
  public TokenSet getWhitespaceTokens() {
    return ThriftTokenTypeSets.WHITESPACES;
  }

  @NotNull
  public TokenSet getCommentTokens() {
    return ThriftTokenTypeSets.COMMENTS;
  }

  @NotNull
  public TokenSet getStringLiteralElements() {
    return ThriftTokenTypeSets.STRINGS;
  }

  @NotNull
  public PsiElement createElement(ASTNode node) {
    return ThriftTokenTypes.Factory.createElement(node);
  }

  public PsiFile createFile(FileViewProvider viewProvider) {
    return new ThriftFile(viewProvider);
  }
}
