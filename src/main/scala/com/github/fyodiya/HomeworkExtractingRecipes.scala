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
  //println(newList)
  newList.mkString("\n")
//  for (line <- newList) {
//    println(line) //after all the filtering save lines in my file
//    sum = sum + 1
//    println(sum)
//  }

  val filteredCookbook = newList.slice(1058, 2910)
//  filteredCookbook.foreach(println)

//  val cookbookWithParagraphs = filteredCookbook.mkString
//  val paragraph = "(\r\r)".r
//  val regexParagraph = "\\r\\n".r
////  val cookbookFinalVersion = new ListBuffer[String]()
////  val paragraphsErased = filteredCookbook.filterNot(paragraph)
////  val cookbookFinal = (regexParagraph replaceAllIn cookbookWithParagraphs)
//  def replacingParagraphs(target: String, replacement: String): String = {
//    (cookbookWithParagraphs).replace(("(\r\r)"), "")
//  }
//  println(cookbookWithParagraphs)

  var rowCount1 = 0
  var rowCount2 = 0
  val customRegex = "\\b[A-Z]+(?:\\s+[A-Z]+)*\\b".r
  var finalList = new ListBuffer[String]()

  def checkChar(xval : String): Unit = {
    val charArr = xval.toCharArray()
    var c = ListBuffer()
    for (el <- charArr) {
      if (el.isUpper || el == " ") {
        c += el
      }
      println(c)
    }
    var result : Boolean = false
    println(c.size)
    println(charArr.size)
    if (c.size == (charArr.size)){
      result = true
    } else { result = false }

    return result

  }
  for (x <- filteredCookbook) {
      rowCount1 = rowCount1 + 1
      var checkCharx = checkChar(x)
      if (x.contains("    ") == true) {
        finalList += x
//        println(x)
      }

        if (checkCharx == true) {
        println(x)
        for (xx <- filteredCookbook) {
          rowCount2 = (rowCount2 + 1)
          var checkCharxx = checkChar(xx)
          println(checkCharxx)
          if ((rowCount2 == (rowCount1 + 1)) == true) {
            if (checkCharxx == true) {
              println("LIELIE BURTI IR")
            } else {
              finalList += xx
            }
          }
        }
      }
      }
    finalList.foreach(println)



      ////  val regexParagraph = {"\\r\\n){2,}"}.r
      ////https://alvinalexander.com/source-code/scala-get-first-paragraph-from-text-string/

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