service SomeService {
    void someMethod()
        throws (
            1: <error descr="type SomeStruct is not an exception">SomeStruct</error> ss,
            2: SomeException se,
        )
}

struct SomeStruct {}
exception SomeException {}