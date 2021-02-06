union SomeUnion {
    1: i32 someField1
    2: i32 <error descr="multiple union values with name 'someField1'">someField1</error>
    3: i32 someField2
    4: i32 someField3
}


union SomeUnion1 {
    1: i32 someField1
    3: i32 someField2
    5: i32 someField3
}

