service A {}
struct <error descr="multiple declarations 'A'">A</error> {}

struct B {}
service <error descr="multiple declarations 'B'">B</error> {}