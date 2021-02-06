struct SomeStruct {
    1: i32 someField1
    <error descr="multiple fields with id 1">1</error>: i32 someField2

    3: i32 someField3
    <error descr="multiple fields with id 3">3</error>: i32 someField4

    5: i32 someField5
    <error descr="multiple fields with id 5">5</error>: i32 someField6
}


struct SomeStruct1 {
    1: i32 someField1
    3: i32 someField2
    5: i32 someField3
}

