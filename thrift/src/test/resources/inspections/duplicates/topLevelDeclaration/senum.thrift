senum A {}
service <error descr="multiple declarations 'A'">A</error> {}

service B {}
senum <error descr="multiple declarations 'B'">B</error> {}