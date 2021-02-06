enum A {}
exception <error descr="multiple declarations 'A'">A</error> {}

exception B {}
enum <error descr="multiple declarations 'B'">B</error> {}