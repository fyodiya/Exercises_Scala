package com.github.fyodiya

object ParsingPoirot extends App {
  val srcFolder = "src/resources"
  val regex = "^[0-9].*"
  val files = Utilities.getListOfFiles(srcFolder, regex)
  println(files.head) //we could potentially have nothing here
  println(files.head.getPath) //this will give us the path as a string
  val filePath = files.head.getPath
  val lines = Utilities.getLinesFromFile(filePath)
  println(s"We have ${lines.length} lines in $filePath")

  //TODO find all lines that mention Poirot
  //you can use filter or yield you can use match or contains on the string
  //TODO how many are there?
  //TODO print first 5 lines that mention Poirot
  //
  //  TODO find chapter index - table of contents - this can get tricky, many approaches possible
  //  TODO print and save table of contents




}
