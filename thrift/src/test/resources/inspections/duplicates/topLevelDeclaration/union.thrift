union A{}
const i32 <error descr="multiple declarations 'A'">A</error> = 1

const i32 B = 2
union <error descr="multiple declarations 'B'">B</error>{}