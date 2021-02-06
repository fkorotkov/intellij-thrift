service SomeService {
    void someMethod(
        1: i32 arg1,
        <error descr="multiple args with id 1">1</error>: i32 arg2,

        30: i32 arg3,
        <error descr="multiple args with id 30">30</error>: i32 arg4,

        45: i32 arg5,
        <error descr="multiple args with id 45">45</error>: i32 arg6,
    )
    void someMethod1(
        1: i32 arg1,
        30: i32 arg3,
        45: i32 arg5,
    )
}