object LoopingPattern extends App {

  val someSequence = "sequence of characters in this case"
  for (item <- someSequence) {
    println(s"Current character is $item")
    if (item == 'a' || item == 'e') println(s"Found some match in $item")
    else println(s"sorry $item is not in our match list")
    //we are creating temporary item for each item in our sequence
    //in this case our sequence is a sequence of characters, so each iten will be a character
  val someNumbers = Seq(3141,324123,123,1,531,15,116)
    println(s"current item is $item")
    if (item > 3000) println(s"nice large number in our sequence is $item")
  }

}
