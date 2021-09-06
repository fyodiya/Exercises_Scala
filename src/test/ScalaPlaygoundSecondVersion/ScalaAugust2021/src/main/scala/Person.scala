case class Person(name: String, relation: String, age: Int, var topSpeed: Int)

//less typing
//pretty print built-in already
//supports pattern matching


object CreatingPersons extends App {
  val me = Person ("Elina", "myself", 30, 27)
  val lesya = Person ("Lesya", "my cat", 1, 14)
   println(me) //case classes have pre-built prettyPrint

  val edik = Person ("Edik", "brother", 31, 36)
  //notice that we don't need to type NEW when creating a new val

  println(edik)
  edik.topSpeed = 56
  println(edik)
  //top speed changes

  //INHERITANCE





  lesya.relation
  println(lesya)



}
