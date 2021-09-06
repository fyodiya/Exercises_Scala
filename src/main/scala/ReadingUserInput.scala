import scala.io.StdIn.readLine //we use it to add extra functionality to our program from extra line

object ReadingUserInput extends App {
  println("We will read same user input")
  val userName = readLine ("what is your name friend?")
  //readLine will ead users input until user presses Enter
  println(s"Great, nice to meet you $userName")
  val height = readLine (s"how tall are you $userName?")
  val megaHeight = height * 10
  println(s"Your new height is $megaHeight")
  val trueHeight = height.toInt * 10
  println(s"Your true height is $trueHeight")

  val topSpeed = readLine ("what is the fastest you've driven?").toDouble
  println(s"Wow! your top speed was $topSpeed!")


}
