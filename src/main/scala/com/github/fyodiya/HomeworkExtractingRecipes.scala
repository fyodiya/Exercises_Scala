package com.github.fyodiya

import scala.Console.println
import scala.collection.mutable.ListBuffer

object HomeworkExtractingRecipes extends App {

  val url = "https://www.gutenberg.org/cache/epub/13177/pg13177.txt"
  val destPath = "src/main/13177-8.txt"
  val fileName = "13177-8.txt"
  val textFromURL = Utilities.getTextFromWeb(url)
  Utilities.saveText(destPath, textFromURL)

  val lines = Utilities.getLinesFromFile(destPath)
  val text = lines.mkString("\n")

  var sum = 0
  val matchA = "*"
  val matchB = "Illustration"
  val matchC = "gutenberg.org"
  val matchD = "This eBook"
  val matchE = "Section"

  val nlList = text.split("\n").toList
  var newList = new ListBuffer[String]()
  for (x <- nlList) {
    if (x.contains(matchA) == false) {
      if (x.contains(matchB) == false) {
        if (x.contains(matchC) == false) {
          if (x.contains(matchD) == false) {
            if (x.contains(matchE) == false) {
              newList += x
            }
          }
        }
      }
    }
  }
  //println(newList)
  newList.mkString("\n")
//  for (line <- newList) {
//    println(line) //after all the filtering save lines in my file
//    sum = sum + 1
//    println(sum)
//  }

  val filteredCookbook = newList.slice(1058, 2909)
//  filteredCookbook.foreach(println)
  val CookbookList = filteredCookbook.toList
  val match1 = "boil"
  val match2 = "turn"
  val match3 = "them"
  val match4 = "add"
  val match5 = "together"
  val filteredCookbookWithoutActions = new ListBuffer[String]()
  for (x <- CookbookList) {
    if (x.contains(match1) == false) {
      {
        if (x.contains(match2) == false) {
          {
            if (x.contains(match3) == false) {
              {
                if (x.contains(match4) == false) {
                  {
                    if (x.contains(match5) == false) {
                      filteredCookbookWithoutActions += x
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
      filteredCookbookWithoutActions.foreach(println)

      //  val matchText = "INDEX TO RECIPES"
      //  val linesNumberWithMatch = newList.zipWithIndex.filter(lineTuple => lineTuple._1.contains(matchText) )
      //  var endingIndex = 0
      //  for (index <- 0 until newList.length) {
      //    if (newList(index).contains(matchText)) endingIndex = index + 1
      //  newList.foreach(println)

      //    val regexStars = "*      "
      //   val charCode = "42"
      //    val filteringStars = mySeq
      //    print(filteringStars)

      //  for (i <- mySeq) { //changed from mySeq to filteringStars
      //    val rgxForWords = "^\\b[A-Z]+\\b".r
      //    val wordsWithCapitalLetter = rgxForWords.findAllIn(i).toSeq
      //
      //    if (i.startsWith("    ")
      //      //      || filteringStars.nonEmpty
      //      || wordsWithCapitalLetter.nonEmpty
      //      || i.startsWith("^[0-9].*")
      //    ) {
      //      //println(i) //after all the filtering save lines in my file
      //      sum = sum + 1
      //      //      println(sum)
      //    }
      //  }
      //val rdd2 = rdd1.filter(x => !(x._1 contains "."))


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