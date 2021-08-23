object StringLooping extends App {
  val myName = "Valdis"
  println(myName(0)) //indexing starts with 0, not 1
  println(myName(5))

  for (c <- myName) println(s"current character is $c")

  for (index <- 0 until myName.length) println(s"Char. no $index is ${myName(index)}")
for ((index, myChar) <- myName.zipWithIndex) println(s"Index $index and char is $myChar")


}
