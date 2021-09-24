package com.github.fyodiya

object HomeworkExtractingRecipes extends App {

  val destDir = "src/resources/"
  val srcPath = "src/resources/13177-8.txt"
  val lines = Utilities.getLinesFromFile(srcPath)
  val text = lines.mkString("\n")

  print(text)

 // def recipeName =

 val regexForWords = "^[A-Z].*".r
 val wordsWithCapitalLetters = regexForWords.findAllIn(text).toSeq

  //alternative regex for finding all capital letters words (/\b[A-Z]+\b/g)


  // val destinationFile = "src/resources/Cookbook.txt"
  // Utilities.saveLines(destinationFile, Cookbook)
}
