package com.github.fyodiya

//import ujson.IndexedValue.False

//import scala.collection.convert.ImplicitConversions.`collection asJava`
import scala.collection.mutable.ListBuffer

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

  //println(mySeq.mkString("Array(", ", ", ")"))
  var sum = 0

  val matchA = "*"
  val matchB = "Illustration"
//  val linesWithMatch = lines.zipWithIndex.filter(lineTuple => lineTuple._1.contains{(matchA) || (matchB)})
//  val linesWithMatchA = lines.filterNot(lines.contains(matchA))

  val nlList = text.split("\n").toList
  var newList = new ListBuffer[String]()
  for (x <- nlList) {
    if(x.contains(matchA) == false) {
      if(x.contains(matchB) == false){
        newList += x
      }
    }
  }
println(newList)

//    val regexStars = "*      "
//   val charCode = "42"
//    val filteringStars = mySeq
//    print(filteringStars)

  for (i <- mySeq) { //changed from mySeq to filteringStars
    val rgxForWords = "^\\b[A-Z]+\\b".r
    val wordsWithCapitalLetter = rgxForWords.findAllIn(i).toSeq

    if (i.startsWith("    ")
//      || filteringStars.nonEmpty
      || wordsWithCapitalLetter.nonEmpty
      || i.startsWith("^[0-9].*")
      )
    {
      //println(i) //after all the filtering save lines in my file
      sum = sum + 1
//      println(sum)
    }
  }
//val rdd2 = rdd1.filter(x => !(x._1 contains "."))
  //FALSE RESULTS (*       )

    //  val numRex = "^[0-9].*"
    //  val filteredFiles = files.filter(_.getName.matches(numRex))
    //  println(filteredFiles)

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
    //  TODO more filtering for false titles meaning titles which do not have ingredients following ingredients


    // val destinationFile = "src/resources/Cookbook.txt"
    // Utilities.saveLines(destinationFile, Cookbook) - saveList
    //println(wordsWithCapitalLetters.mkString("\n"))
    //  Utilities.saveLines("src/resources/Cookbook.txt", titles)

  }