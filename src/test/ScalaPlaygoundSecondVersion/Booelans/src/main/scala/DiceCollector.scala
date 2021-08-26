import scala.util.Random.nextInt
object DiceCollector extends App {

  println("Testing dice throws")
for (n <- 0 to 10) println(nextInt(6))
  val singleDice = for (n <- 0 to 20) yield nextInt(6)+1
  println(singleDice.mkString(","))
  println(singleDice.count(_ == 6)) //syntax for counting specific occurences


  //TODO create a value for number of dice throws (or ask user for a number)
  //TODO create sequence of doubleDice throws
  //TODO calculate sum, avg, as well as max, min (12 and 2)
  //print number of times each number from 2 to 12 occurs in sequence


}
