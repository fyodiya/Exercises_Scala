import scala.io.StdIn.readLine

object MapsExercise extends App {

  //you can use yield to create immutable map, or use the above for loop and mutable map
  // println(myMap)

  println("Split sentence into words")
  println("Create a mapping of words to word lengths")

  val sentence = readLine("What is your sentence?")
  val words = sentence.split(" ")
  val myMap= (for (word <- words) yield (word, word.length)).toMap
  println (myMap)

  //less recommended would be the usage of a mutable map
  {val mutableMap = scala.collection.mutable.Map[String, Int]() //an empty map to be filled in
  for (word <- words) {
    println("Adding", word, word.length)
    mutableMap += (word -> word.length)
  }
  println(mutableMap)
  }

  val mutableLinkedHashMap = scala.collection.mutable.LinkedHashMap[String, Int]() //an empty map to be filled in
  for (word <- words) {
    println("Adding", word, word.length)
    mutableLinkedHashMap += (word -> word.length)
  }
  println(mutableLinkedHashMap)




}
