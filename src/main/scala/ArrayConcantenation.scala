object ArrayConcantenation extends App {
  val smallNumbers = (1 to 10).toArray
  val bigNumbers = (100 to 109).toArray
  val combinedNumbers = smallNumbers ++ bigNumbers
  println(combinedNumbers.mkString(","))

  val numbersFromRange = (1 to 5) ++ (30 to 33) ++ (55 to 59) ++ (-7 to -2) ++ (1008 to 960 by 4)
  println(numbersFromRange.mkString(","))
  println(numbersFromRange.sum, numbersFromRange.max, numbersFromRange.min, numbersFromRange.length)

val sortedNumbers = numbersFromRange.sorted
  println(numbersFromRange.mkString(","))






}
