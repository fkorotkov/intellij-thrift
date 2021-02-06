service SomeService {
    void someMethod()
    void <error descr="multiple methods with name 'someMethod'">someMethod</error>()
    void someMethod1()
}

service SomeService1 {
    void someMethod()
    void someMethod1()
}