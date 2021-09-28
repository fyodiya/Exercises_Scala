package com.github.fyodiya

//import java.io.FileInputStream
//import scala.io.BufferedSource
//import scala.util.control.Breaks.{break, breakable}

//import java.io.FileInputStream
//import scala.collection.immutable.WrappedString
//import scala.io.BufferedSource

object HomeworkExtractingRecipes extends App {

    val url = "https://www.gutenberg.org/cache/epub/13177/pg13177.txt"
    val destPath = "src/main/13177-8.txt"
    val fileName = "13177-8.txt"
    val textFromURL = Utilities.getTextFromWeb(url)
//println(textFromURL)
  Utilities.saveText(destPath, textFromURL)


  val lines = Utilities.getLinesFromFile(destPath)
  val text = lines.mkString("\n")
  //println(text)

  //val text = lines.toSeq
  val mySeq = text.split("\n")

  println(mySeq)
  var summa = 0


  for (i <- mySeq) {
      val rgxForWords = "[A-Z]".r
      val wordsWithCapitalLetter = rgxForWords.findAllIn(i).toSeq
      if (i.startsWith("    ") || wordsWithCapitalLetter.length != 0) {
        println(i) //after all the filtering save lines in my file
        summa = summa + 1
        println(summa)
      }
    }

  //println(mySeq)
//  val mySeq = Seq(text)
//  println(mySeq)

//def filteringIngredients(mySeq:WrappedString) = {
  //val regexForIngredients = "\n"
  //val ingredients = "    "
  //for(ele <- mySeq){
   // if(ele == "    ") {
    //  println("Jauna rinda")
    //}

  //println(ingredients)

  // filteringIngredients(mySeq)
// val ingredients = mySeq.filter(line => lines.startsWith("^[0-9]".r))
// println(ingredients)
//}
//
//  //alternative regex for finding all capital letters words (/\b[A-Z]+\b/g)
//  filteringIngredients(mySeq)
//  val regexForTitles = "^\\b[A-Z]+\\b".r
//  val titles = regexForTitles.findAllIn(text).toSeq
//  titles.foreach(println)
//  //    TODO more filtering for false titles meaning titles which do not have ingredients following ingredients
//
//
//
//


  // val destinationFile = "src/resources/Cookbook.txt"
  // Utilities.saveLines(destinationFile, Cookbook)
  //println(wordsWithCapitalLetters.mkString("\n"))
//  Utilities.saveLines("src/resources/Cookbook.txt", titles)

}