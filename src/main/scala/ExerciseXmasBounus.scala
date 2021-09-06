import scala.io.StdIn.readLine

object ExerciseXmasBonus extends App {
  //Ask for person's name
  //Ask for how long they have worked at the firm
  //Ask for monthly wage
  //Calculate Xmas bonus if they have worked at least 2  years
  //Bonus is years worked over 2 years * 15% of monthly wage
  //so 5 years worked, 1000 Euros wage would give 450 Euro bonus (3 years * 150)

  //if they are not eligible for bonus you should say so
  val userName = readLine ("What is your name?")
  val userExperience = readLine ("For how many years have you worked at this firm?").toInt
  if (userExperience<=2) println (s"Sorry, $userName, You are not eligible for bonus yet")
  else {
    val userWage = readLine("What is your monthly wage?").toDouble
    val userBonusPerYear = userWage * 1.15 - userWage
    val xmasBonus = (userExperience - 2) * userBonusPerYear
    println(s" $userName, Your christmas bonus is $xmasBonus eur ")
  }

}
