include 'bar.thrift'
include 'util/baz.thrift'
include 'util\bax.thrift'

enum Numberz{
}

typedef i64 UserId

typedef map<string,Bonk> MapType

exception Xception {
  1: i32 errorCode,
  2: string message
}

exception Xception2 {
  1: i32 errorCode,
  2: Xtruct struct_thing
}
service ThriftTest{
}

struct StructA {
}

struct StructB {
  1: list<<caret>>
}

