exception SomeException {
    1: i32 someField1
    <error descr="multiple fields with id 1">1</error>: i32 someField1

    2: i32 someField3
    <error descr="multiple fields with id 2">2</error>: i32 someField4

    90: i32 someField5
    <error descr="multiple fields with id 90">90</error>: i32 someField6
}

exception SomeException {
    1:  i32 someField1
    2:  i32 someField2
    90: i32 someField3
}
