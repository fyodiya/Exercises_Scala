import scala.util.Random.nextInt //so I want to use specific function from Random library

object DiceCollector extends App {
  println("Testing dice throws")
  for (n <- 0 to 30) println(nextInt(6))
  val singleDice = for (n <- 0 to 20) yield nextInt(6)+1 //n is not used we could have called it _
  println(singleDice.mkString(","))
  println(singleDice.count(_ == 6)) //syntax or for counting specific occurences

  //TODO create a value for number of dice throws (or ask user for number)
  val numThrows = 1_000_000
  //TODO create sequence of doubleDice throws
  val dicePerThrow = 6

  def throwDice(howMany:Int = 2):Int = {
    var result= 0
    for (_ <- 0 until howMany) result += nextInt(6)+1 //so howMany times we are adding a dice throw to our result
    4 //chosen by random dice :)
    result
  }
  //  val doubleDice = for (_ <- 0 until numThrows) yield nextInt(6)+1+nextInt(6)+1
  val doubleDice = for (_ <- 0 until numThrows) yield throwDice(dicePerThrow) //by default we throw 2 dice
  println(doubleDice.slice(0,30).mkString(","))
  println(s"Min throw is ${doubleDice.min}")
  println(s"Max throw is ${doubleDice.max}")
  val allThrowsSum = doubleDice.sum
  println(s"All throws summed is $allThrowsSum")
  val throwsAvg = allThrowsSum.toDouble / doubleDice.length
  println(s"Average throw has the value $throwsAvg")

  //print number of times each number from 2 to 12 occurs in the sequence
  val throwCounts = for (n <- dicePerThrow to dicePerThrow*6) yield doubleDice.count(_ == n) //so with yield I am saving each result of counting in a sequence
  println(throwCounts.mkString(","))

  for (n <- dicePerThrow to dicePerThrow*6) {
    val cnt = doubleDice.count(_ == n)
    println(s"$n occurs $cnt times")
  }
}