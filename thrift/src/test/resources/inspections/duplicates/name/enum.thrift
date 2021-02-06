enum SomeEnum {
    VALUE1 = 1
    <error descr="multiple enum value names 'VALUE1'">VALUE1</error> = 2

    VALUE2 = 3
    <error descr="multiple enum value names 'VALUE2'">VALUE2</error> = 2
}

enum SomeEnum1 {
    VALUE1 = 1
    VALUE2 = 2
}