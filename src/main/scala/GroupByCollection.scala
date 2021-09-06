object GroupByCollection extends App {
  println("Groups your collection into a Map of smaller collections depending on a key")
  val numbers = (0 to 10).toArray
  //  val grouped = numbers.groupBy(_ % 2) //in effect we are saying group by even or odd
  val grouped = numbers.groupBy(n => n % 2) //this is the full syntax, above is shorter for one variable
  println(grouped)
  //we need something nicer to print the individual Array inside our map
  //we are getting Map of Integer keys (reminders) and Array of Integers with this property
  for ((key, value) <- grouped) {
    val stringFromArray = value.mkString(",")
    if (key == 0) {
      println(s"Even numbers are $stringFromArray")
    } else {
      println(s"Odd numbers are $stringFromArray")
    }
  }

  val text = "The quick brown fox jumps over the lazy dog"
  val words = text.split(" ")

  //we want to group the words by their lengths
  val groupedWordsByLength = words.groupBy(word => word.length) //also groupBy(_.length) should work
  for ((key,value) <- groupedWordsByLength) {
    val stringFromArray = value.mkString(",")
    println(s"Words length $key are $stringFromArray ")
  }

  val bigText = "The beige hue on the waters of the loch impressed all, including the French queen, before she heard that symphony again, just as young Arthur wanted"
  val manyWords = bigText.toLowerCase.replace(",", "").split(" ") //without commas

  val groupedWordsByFirstLetter = manyWords.groupBy(word => word.head) //we group words by the first letter same as word(0)
  for ((key,value) <- groupedWordsByFirstLetter) {
    val stringFromArray = value.mkString(",")
    println(s"Words starting with $key are $stringFromArray ")
  }

}