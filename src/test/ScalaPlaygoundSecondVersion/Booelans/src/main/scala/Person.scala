case class Person(name: String, relation: String, age: Int)

//less typing
//pretty print built-in already
//supports pattern matching


object CreatingPersons extends App {
  val me = Person ("Elina", "myself", 30)
  val lesya = Person ("Lesya", "my cat", 1)
   println(me)
  lesya.relation
  println(lesya)



}
