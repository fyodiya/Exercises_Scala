package com.github.fyodiya

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
  newList.mkString("\n")

  val filteredCookbook = newList.slice(289, 2910)

  var rowCount1 = 0
  var rowCount2 = 0
  val customRegex = "\\b[A-Z]+(?:\\s+[A-Z]+)*\\b".r
  val finalList = new ListBuffer[String]()

  def checkChar(stringForArr : String) : String = {
    var c = ""
    for (el <- stringForArr) {
      if (el.isUpper || el == ' ') {
        c += el
      }
    }
    if (c.length >= stringForArr.length) {
      return stringForArr
    } else {
      return "Nav"
    }
}

  for (x <- filteredCookbook) {
      rowCount1 = rowCount1 + 1
      if (x.contains("    ")) {
        finalList += x
      }
      if (checkChar(x).toString == x.toString) {
        finalList += x.toString
        //for (xx <- filteredCookbook) {
         // rowCount2 = (rowCount2 + 1)
          //if (rowCount2 == (rowCount1 + 1)) {
            //if (checkChar(xx).toString == x.toString) {
              //finalList += x.toString
            //}
          //}
        //}
      }
      }
    finalList.foreach(println)

  val finalCookbook = finalList.toArray

      val destinationFile = "src/resources/Cookbook.txt"
      Utilities.saveLines(destinationFile, finalCookbook)
      println(finalList.mkString("\n"))
      //  Utilities.saveLines("src/resources/Cookbook.txt", titles)

    }