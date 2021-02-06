service SomeService {
    void someMethod(
        1: i32 arg1,
        2: i32 <error descr="multiple args with name 'arg1'">arg1</error>,
        3: i32 arg2,
        4: i32 arg3,
    )
    void someMethod1(
        1: i32 arg1,
        2: i32 arg2,
        3: i32 arg3,
    )
}
