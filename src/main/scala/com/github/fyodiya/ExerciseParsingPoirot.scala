package com.github.fyodiya

object ExerciseParsingPoirot extends App {
val srcFolder = "src/resources"
  val regex = "^[0-9].*"
  val files = Utilities.getListOfFiles(srcFolder, regex)
  println(files.head) //we could potentially get nothing here
  println(files.head.getPath) //this will give us the path as a string

  val filePath = files.head.getPath

  val lines = Utilities.getLinesFromFile(files.head.getPath)
  println(s"We have ${lines.length} lines in our text $filePath")

  //TODO get all lines that mention "Poirot"
  val filterText = "Poirot"
  val filteredLines = for (line <- lines if line.contains(filterText)) yield line
  println(s"Lets print all lines that contain word $filterText")
  println(filteredLines.mkString("\n"))

  //TODO count these lines
  val allLines = filteredLines.mkString
  def countLines {
    val src = allLines
    val count = src.size
    println(count)
  }
  //TODO print first 5 of these lines

  //TODO find table of contents
  //TODO print and save table of contents



}
