struct A {}
typedef i32 <error descr="multiple declarations 'A'">A</error>

typedef i32 B
struct <error descr="multiple declarations 'B'">B</error> {}