service SomeService {
    void someMethod()
        throws (
                1: SomeException sexc1,
                2: SomeException <error descr="multiple throws with name 'sexc1'">sexc1</error>,
                3: SomeException sexc2,
                4: SomeException sexc3,
            )
    void someMethod2()
        throws (
               1: SomeException sexc1,
               2: SomeException sexc2,
               3: SomeException sexc3,
            )
}

exception SomeException {}