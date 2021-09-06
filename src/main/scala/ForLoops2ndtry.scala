object ForLoops2ndtry extends App {
  //we can do everything while loops but for loops offer us convenience

  //we use for loops when we know exact number of items to go through
  for (i <- 0 to 5) {
    println(s"i is now $i")
  }
  for (i <- 0 until 5) {
    println(s"i is now $i")
  }

  val myName = "Elina"
  for (c <- myName) {
    println(s"Current letter is $c")
  }
  //there is a convention to use _ when value isn't important

  for (_ <- 0 until 5) {
    println("Doing something 5 times but I don't really care about the number")
  }

  //for loop variants you should use short names or characters

  myName.foreach(println)
  //we are saying for each individual number of myName
  for (char <- myName) println(char) //same as above

  //one cycle is called "an iteration"

  for  (number <- 0 until 10) {
    if (number  % 2 == 0) { //these brackets aren't strictly necessary for a single statement
      println(s"$number is even.")
    } else {
      println(s"$number is odd.")
    }
  }
}
