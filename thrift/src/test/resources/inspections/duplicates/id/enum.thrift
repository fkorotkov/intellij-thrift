enum SomeEnum {
    VALUE1 = 1
    VALUE2 = <error descr="multiple enum values with id 1">1</error>

    VALUE3 = 2
    VALUE4 = <error descr="multiple enum values with id 2">2</error>
}

enum SomeEnum1 {
    VALUE1 = 1
    VALUE2 = 2
}