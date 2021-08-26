object SequenceOperations extends App {
  val myText = "A quick brown fox jumped over a sleeping dog"
  val myWords = myText.split(" ")
  println(s"My text has ${myText.length} characters")
  println(s"My text has ${myWords.length} words")

  val bigWords = for (word <- myWords) yield word.toUpperCase
  println(bigWords.mkString(" : : :"))

  myWords.slice(3, 5).mkString(",")

  val numbers = (0 to 10).toArray
  val divBy3 = numbers.filter(n => n % 3 == 0)
  println(divBy3.mkString(","))

  val squares = numbers.map(n => n * n)
  println(squares.mkString(","))

  for (number <- numbers) {
    println(s"I can do something with $number")
  }






}
