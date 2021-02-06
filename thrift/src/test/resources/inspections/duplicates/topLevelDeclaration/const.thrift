const i32 A = 1;
enum <error descr="multiple declarations 'A'">A</error> {}

enum B {}
const i32 <error descr="multiple declarations 'B'">B</error> = 2