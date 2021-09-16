package com.github.fyodiya

object CleanWill extends App {
val src = "src/resources/The Case of the Missing Will.txt"
  val dst = "src/resources/The Case of the Missing Will_cleaned.txt"
//read src
  // write to dst the cleaned version without the project Gutenberg footer

  val lines = Utilities.getLinesFromFile(src)
  val matchText = "THE END"
  val linesNumberWithMatch = lines.zipWithIndex.filter(lineTuple => lineTuple._1.contains(matchText) )
  //val endingIndex = linesNumberWithMatch.head._2+1
  //val cleanText =lines.slice(0,endingIndex)
  //val endingText = lines.indexWhere(line => line.contains(matchText))
  //val cleanText = lines.slice(0,endingText)
//  Utilities.saveLines(dst,cleanText)

//  var endingIndex = 0
//  for ((line, index) <- lines.zipWithIndex) {
//    if (line.contains(matchText)) endingIndex = index + 1
//  }

var endingIndex = 0
for (index <- 0 until lines.length) {
  if (lines(index).contains(matchText)) endingIndex = index+1

  val cleanText = lines.slice(0,endingIndex)
  Utilities.saveLines(dst,cleanText)

  //few options or methods to choose from


}


}
