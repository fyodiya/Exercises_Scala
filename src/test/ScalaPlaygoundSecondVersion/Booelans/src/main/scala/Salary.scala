import scala.io.StdIn.readLine

object Salary extends App {

  //ask for name
  //ask for how long they have worked
  //ask for monthly wage
  //calculate Xmas bonus if they have worked over 2 years
  //if more than 2 years bonus is +15%
  //if more than 5 years bonus is 1000 euros

  //if they aren't eligible for option you should say so

  println("what's your name?")
  val userName = readLine ("What is your name friend?")
  //readLine will read user input until user presses Enter
  println(s"Great! Nice to meet you $userName!")
  val salary = readLine (s"How much do you earn $userName?")
  println("oh, thanks for the information")
  val timeWorked = readLine ("How many years have you worked at this place?").toInt
  if (timeWorked < 2)
    println(s"Oh $userName, sorry, you won't get a Xmas bonus")
  else {
    if (timeWorked > 2) {
      val userBonus = salary*0.15
      println("Congratulations " + userName + " your Xmas bonus will be 15% of " + salary)
    }
  }
    if (timeWorked > 2) println(s"omg, $userName your Xmas bonus will be 1000 euros!")
  }


}
