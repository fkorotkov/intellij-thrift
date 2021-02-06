typedef i32 A
union <error descr="multiple declarations 'A'">A</error> {}

union B {}
typedef i32 <error descr="multiple declarations 'B'">B</error>