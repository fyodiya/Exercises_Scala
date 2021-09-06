object SequenceIntro extends App {
  val myName = "Valdis" //so string is a sequence of characters, a special case of sequence
  val mySeq = myName.toArray //so this is an array of characters, array is a sequence of characters
  println(mySeq)
  for (item <- mySeq) println(item)
  mySeq.foreach(println) //we can print each item in our collection with this shorter syntax
  val mySentence = "a quick brown fox jumped over a sleeping dog"
  println(mySentence.length) //how many characters
  println(mySentence)
  val myWords = mySentence.split(" ")
  myWords.foreach(println)
  println(myWords(2)) //3rd word in sequence , of course sequence has to be of length 3 or greater
  //sequence also have length
  println(myWords.length) //how many words
  //last word would be
  println(myWords(8), myWords.last) //.last is nicer

  val myNumbers = (0 to 15).toArray.toSeq //we create a Sequence of Integers
  println(myNumbers(4)) //5th number so it will be 4 because 0,1,2,3,4,.....

  //lets print all numbers in our sequence
  myNumbers.foreach(println)

  //so Sequences and collections in general exist to store similar items

  //we can also use yield syntax to create our sequences
  val moreNumbers = for (n <- 6 to 23) yield n

  println(moreNumbers)


}
