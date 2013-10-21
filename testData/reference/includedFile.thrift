include 'util/included.thrift'

struct StructB {
  1: list<included.<caret>>
}

