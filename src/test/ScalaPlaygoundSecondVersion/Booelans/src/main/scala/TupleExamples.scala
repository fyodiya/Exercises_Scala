object TupleExamples extends App {

  //TUPLES are a fixed collection of values of different types
  //in Scala they have an annoying syntax to access, but they're still useful
  // because of above mentioned different type support (which ARRAY type can't do)

  val myTuple = ("name", "Valdis")
  println(myTuple._1)
  println(myTuple._2)

  //so Tuples of six 2 are used to create MAPS
  //but tuples  in Scala go to size 22
  val myBiggerTuple =  ("food", "drinks", 100, 200, true, Array(1,2,4,7), Map("one" -> 1, "two" -> 2))
  //I can store whatever I want
  println(myBiggerTuple._7.getOrElse("two", 0))

  //we can unpack the tuples
  val (food, drink, num1, num2, myBul, myArr, myMap) = myBiggerTuple

  val (_, alsoDrink, _, _, _, _, _) = myBiggerTuple

 def prettyAdd (a: Int, b: Int): (Int, String) = {
   val res = a + b
   val stringRes = s"$a+$b=$res"
   (res, stringRes) //so we are returning a Tuple of integers and String
 }

  val myRes = prettyAdd(5,23)
  println(myRes._1)
  println(myRes._2)
  println(myRes)
  val (myInt, myString) = prettyAdd(30,51)
  println(myInt)
  println(myString)




}
