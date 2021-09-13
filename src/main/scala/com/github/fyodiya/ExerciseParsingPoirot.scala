package com.github.fyodiya

case class Line(index:Integer, text:String) {
  def fancyLine:String = s"Line $index: $text"
}

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
  //val allLines = filteredLines.mkString
 //def countLines() {
 //val src = allLines
   //val count = src.length
   //println(count)}

  val matchWord = "Poirot"
  val poirot = lines.filter(_.contains(matchWord))
  println(s"There are ${poirot.length} lines that contain $matchWord")
  println(poirot.head)
  poirot.slice(0,5).foreach(println)
  for (line <- poirot.slice(0,5)) println(line)

  //if we need line number we can just generatoe those
  for (i <- 0 until 5) println(s"Found line with array index $i: ${poirot(i)}") //this could lead to exception if we do not check array boundaries


  for ((line, index) <- lines.slice(0,1000).zipWithIndex) {
    if (line.contains(matchWord)) {
      println(s"Line ${index+1}: $line)") //for text files we start Line numbering with 1
    }
  }

  val poirotLines = for ((line, index) <- lines.zipWithIndex if line.contains(matchWord)) yield line
  println(s"There are ${poirotLines.length} lines that contain $matchWord")
  //so the above would be same as using filter but we to use index and the new Line case class

  val poirotCases = for ((line, index) <- lines.zipWithIndex if line.contains(matchWord)) yield Line(index+1, line)
  //with this approach we preserved the original index as well as the text
  //we could used a tuple to store index and text or maybe mini Array

  val hastingsMatch = "Hasting"

  val poirotAndHastings = poirotCases.filter(_.text.contains(hastingsMatch))
  println(s"$matchWord and $hastingsMatch appear together in ${poirotAndHastings.length} lines")
  println(poirotAndHastings.head)

  //we could do the above in one line (no index saved here)
  //in scala you generally want to chain multiple filters instead of joining multiple contains with &&
  val poirotAndHastingsLines = lines.filter(_.contains(matchWord)).filter(_.contains(hastingsMatch))
  println(poirotAndHastingsLines.head)

  val destinationFile = "src/resources/poirot.txt"
  Utilities.saveLines(destinationFile, poirotLines)

  //if I wanted to save the original line number I could use the information found in PoirotCases which includes number
  //our Utilities.saveLines takes Array of Strings not Array of Lines so we need to remap each Line in our Array to String
  Utilities.saveLines("src/resources/poirot_line_numbers.txt", poirotCases.map(_.toString))



  //we could create our own format on the run just add fancyLine or whatever function/method to our case class
  Utilities.saveLines("src/resources/poirot_line_numbers_fancy.txt", poirotCases.map(_.fancyLine))

  //
  //  TODO find chapter index - table of contents - this can get tricky, many approaches possible
  //  TODO print and save table of contents

  //easy way to print table of contents is simply use slice only question is can we find the index with program or by hand input

  //so hard coded inflexible way first:
  val tableOfContents = lines.slice(35,48) //not great because only applies to that one book...also off by one errors

  println(tableOfContents.mkString("\n")) //so same as tableOfContents.foreach(println)

  Utilities.saveLines("src/resources/styles_toc.txt", tableOfContents)

  //TODO ideas to think about

  //we can look for first occurence of chapter and then go until no more chapters are available

  //the issue is the chapters that appear in begging of each chapter, so we have doubles

  //we might have some other ways of finding the start of table of contents and end
  //possibly whitespace
  //maybe some lines before that?

}