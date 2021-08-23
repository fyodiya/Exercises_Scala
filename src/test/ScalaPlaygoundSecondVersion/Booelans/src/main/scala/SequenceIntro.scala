object SequenceIntro extends App {
 val myName = "Valdis"
  val mySeq = myName.toArray
  println(mySeq)
  for (item <- mySeq) println(item)
  mySeq.foreach(println)
  val mySentence = "a quick brown fox jumped over a sleeping dog"
  println(mySentence.length)
  println(mySentence)
  val myWords = mySentence.split(" ")
  myWords.foreach(println)
println(myWords(2))
println(myWords.length)
println(myWords(8), myWords.last)

val myNumbers = (0 to 15).toArray.toSeq
println(myNumbers(4))

  myNumbers.foreach(println) //prints all numbers in our sequence

  //so sequences are collections in general

  val moreNumbers = for (n <- 6 to 23) yield n

  println(moreNumbers)

}
