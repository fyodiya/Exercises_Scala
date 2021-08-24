object ArrayConcantenation extends App {
  val smallNumbers = (1 to 10).toArray
  val bigNumbers = (100 to 109).toArray
  val combinedNumbers = smallNumbers ++ bigNumbers
  println(combinedNumbers.mkString(","))

  val numbersFromRange = (1 to 5) ++ (30 to 33) ++ (55 to 59) ++ (-7 to -2)
  println(numbersFromRange.mkString(","))



}
