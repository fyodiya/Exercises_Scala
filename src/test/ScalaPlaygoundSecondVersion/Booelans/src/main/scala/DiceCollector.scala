import sun.security.util.Length

import scala.io.StdIn.readLine
import scala.util.Random.nextInt
object DiceCollector extends App {

  println("Testing dice throws")
for (n <- 0 to 10) println(nextInt(6))
  val singleDice = for (n <- 0 to 20) yield nextInt(6)+1
  println(singleDice.mkString(","))
  println(singleDice.count(_ == 6)) //syntax for counting specific occurrences



  //TODO create a value for number of dice throws (or ask user for a number)
  val numThrows = 1_000
  //TODO create sequence of doubleDice throws
  val doubleThrow = for (_ <- 0 until numThrows) yield nextInt(6)+1+nextInt(6)
  println(doubleThrow.slice(0,30)mkString(","))

  {def throwDice(howMany: Int = 2) = {
    var result = 0
    for (_ <- 0 until howMany) result += nextInt(6)+1
    result
  }}

  //TODO calculate sum, avg, as well as max, min (12 and 2)
println(s"Min throw is ${doubleThrow.min}")
println(s"Max throw is ${doubleThrow.max}")

val allThrowSum = doubleThrow.sum
println(s"All throw sum is $allThrowSum")
val throwsAvg = allThrowSum/doubleThrow.length
println(s"average throw is $throwsAvg")


  //print number of times each number from 2 to 12 occurs in sequence
val throwCounts = for (n <- 2 to 12) yield doubleThrow.count(_ == n)
  println(throwCounts.mkString(","))


  val numberOfDiceThrows = readLine ("Please enter number of dice throws")
  val numberOfDiceThrowsSeq = numberOfDiceThrows.toArray.toSeq
  val DiceThrowSum = numberOfDiceThrows.sum
  val DiceThrowsMax = numberOfDiceThrows.max
  val DiceThrowsMin = numberOfDiceThrows.min






}
