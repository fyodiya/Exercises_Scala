package com.github.fyodiya

import scala.collection.immutable.ListMap

object ExercisePrideAndPrejudice extends App {
//download file with scala instead of by hand
  //save to src/resources
  //read,
  //extract all years (which are 4 digits long)
  //extract all words with capital letters

  //extra challenge - words which are not first in a sentence

  val url = "https://www.gutenberg.org/files/1342/1342-0.txt"
  val fileName = url.split("/").last //so this will work even if there is nothing to split
  val destPath = s"src/resources/$fileName"

  println(s"Will check if $destPath exists")
  println(Utilities.isFileThere(destPath))
  println(Utilities.isFileThere("src/resources/61262-0.txt"))

  if (!Utilities.isFileThere(destPath)) {
    println(s"No $destPath we need to download from $url")
    val text = Utilities.getTextFromWeb(url)
    //just notice this could take a bit
    //so this is called blocking call
    //meaning that you cant proceed until it is finished
    Utilities.saveText(destPath, text)
  } //we could add ELSE but here we will save and then load it

  val lines = Utilities.getLinesFromFile(destPath) //unless something went wrong with my HardDrive or SSD or Internet I should have the source
  val text = lines.mkString("\n")

  //  val years = "\\d\\d\\d\\d".r
  //  val years = "\\d{4}".r //same as above, better for longer numbers or range of numbers to find
  //  val years = "[0-9]{4}".r //same as above, better for longer numbers or range of numbers to find
  //  val years = "[1-2][0-9]{3}".r //so 1000 to 2999 more realistic range :)
  val years = "(1[0-9]{3})|(20[0-2][0-9])".r //so 1000 to 2029 more realistic range :)

  val allYears = years.findAllIn(text).toSeq
  allYears.foreach(println)

  val words = text.split("\\W+")
  words.slice(0,20).foreach(println)
  //  val hasUpperCase = text.filter(_.isUpper).toSeq
  //  hasUpperCase.foreach(println)
  val rgxForWords = "[A-Z]+[a-z]+".r
  val wordsWithCapitalLetter = rgxForWords.findAllIn(text).toSeq
  wordsWithCapitalLetter.slice(1,100).foreach(println)

  val wordCount = wordsWithCapitalLetter.groupBy(identity).mapValues(_.size).toMap
  val orderedCount = wordCount.to(collection.immutable.SortedMap)
  for ((key,value) <- orderedCount) {
    println(key, value)
  } //so this was alphabetical ...
  //  val countTuples = for ((key,value) <- orderedCount) yield (key,value)

  //https://alvinalexander.com/scala/how-to-sort-map-in-scala-key-value-sortby-sortwith/
  val sortedCount = ListMap(wordCount.toSeq.sortBy(_._2):_*) //so we want to sort by value not key
  sortedCount.slice(0,50).foreach(println)
  sortedCount.toSeq.reverse.slice(0,50).foreach(println)

}
