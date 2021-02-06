service SomeService {
    void someMethod()
        throws (
                1: SomeException sexc1,
                <error descr="multiple throws with id 1">1</error>: SomeException sexc2,

                25: SomeException sexc3,
                <error descr="multiple throws with id 25">25</error>: SomeException sexc4,
            )
    void someMethod2()
        throws (
               1: SomeException sexc1,
               25: SomeException sexc3,
            )
}

exception SomeException {}