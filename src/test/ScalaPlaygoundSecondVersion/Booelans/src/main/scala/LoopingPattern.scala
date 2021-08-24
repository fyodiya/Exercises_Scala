object LoopingPattern extends App {

  val someSequence = "Sequence of characters in this case"
  for (item <- someSequence) {
    println(s"Current character is $item")
    if (item == 'a' || item == 'e') println(s"Found match in $item")
    else println(s"Sorry $item is not in our match list")
  }
  //there is in fact a shorter way of getting these characters
  val someNumbers = Seq(3141,3243214,123,1,531,143,15,115)
  for (item <- someNumbers) {
    println(s"Current item is $item")
    if (item > 3000) println(s"Nice large number in our sequence $item")
  }
}
