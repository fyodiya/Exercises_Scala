import com.github.fyodiya.Utilities.getLinesFromFile

import java.io.PrintWriter

object ReadingPoem extends App {
  //TODO read stopping by poem from src/resources/stopping_by.txt we can use our Utilities method
  //TODO get poem name - it is the first line
  //TODO get poet - it is in the 2nd line but we want just the poet

  //TODO Get all lines which contain "woods" somewhere in the text
  //so instead of startsWith we use contains

  val filePath = "src/resources/stopping_by.txt"
  val lines = getLinesFromFile(filePath)
  val firstLine = lines.head
  println(firstLine)
  val secondLine = lines(1)
  //println(secondLine)
  val secondLineSplit = secondLine.split(" ")
  //  val poetFullName = secondLineSplit(1) + " " + (secondLineSplit(2))
  val poetFullName = secondLine.split("BY").last.trim //even safer than number as long as there is something
  //  val poetFullName = secondLine.split("BY")(1).trim
  //is there a possiblity to do it with less actions?
  println(poetFullName)

  val filterText = "woods"
  val filteredLines = for (line <- lines if line.contains(filterText)) yield line
  println(s"Lines starting with $filterText")
  println(filteredLines.mkString("\n"))

  //  val filteredText = filteredLines.mkString("\n")

  val relative_save_path = "src/resources/stopping_by_selection.txt"
  // PrintWriter


}
