import com.github.fyodiya.Utilities
import com.github.fyodiya.Utilities.getLinesFromFile

import scala.collection.mutable.ArrayBuffer

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
  //is there a possibility to do it with less actions?
  println(poetFullName)

  val filterText = "woods"
  val filteredLines = for (line <- lines if line.contains(filterText)) yield line
  println(s"Lines starting with $filterText")
  println(filteredLines.mkString("\n"))

  //val filteredText = filteredLines.mkString("\n")

  val relative_save_path = "src/resources/stopping_by_selection.txt"
  //  val filteredLinesWithHeaders = Array(firstLine) ++ Array(poetFullName) ++ filteredLines
  val filteredLinesWithHeaders = Array(firstLine, poetFullName) ++ filteredLines //same result as above

  //alternative approach for time when you are building up a longer Array and do not have all pieces yet
  val resultsBuffer = ArrayBuffer[String]()
  resultsBuffer += firstLine
  resultsBuffer += poetFullName
  resultsBuffer ++= filteredLines //we are adding full Array to our buffer not just a single element
  //if we see ANY DATA TYPE we should get suspicious,
  //because it means that we have not done the right operation
  Utilities.saveLines(relative_save_path, filteredLines)

  //add more string items/lines to our buffer
  val resultsFinalized = resultsBuffer.toArray //nothing more can be added to this

  Utilities.saveLines(relative_save_path, resultsFinalized) //so this will always overwrite the old file


  Utilities.saveLines(relative_save_path, Array("my snowy lines are no good", "sleepy time"))

}
