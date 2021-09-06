import java.util.Calendar
import scala.io.StdIn.readLine

object ExerciseAug12Age100 extends App {
  //TODO Ask user for the current Year
  //TODO ask user for their name
  //TODO ask user for their age...

  //TODO calculate and print the year when the user will be 100 years old

  //remember about typecasting to numeric types from string
//  val currentYear = readLine("What is the year, my friend?").toDouble
  val now = Calendar.getInstance()
  val currentYear = now.get(Calendar.YEAR) //so now i do not need to ask for year anymore
  val currentMonth = now.get(Calendar.MONTH)
  println(s"Current year is $currentYear and month is $currentMonth") //months just like most things in programming start with 0
  val userName = readLine("What is your name?")
  println(s"Great! Nice to meet you $userName!")
  val yourAge = readLine("How old are you?").toDouble //of course there would be an exception here, if user enters text instead of number
  val age = 100
//  val yearWhen100 =(age-yourAge+currentYear).toInt //so similar to floor function in some languages
  val yearWhen100 =(age-yourAge+currentYear).round //another option, difference being this would round up from .5 to 1

  println(s"$userName, it will be year $yearWhen100 when you turn 100 years old!")
}
