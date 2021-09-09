import com.github.fyodiya.Utilities.getLinesFromFile

object ReadingPoem extends App {
  println(System.getProperty("user.dir"))
  val filePath = "src/resources/stopping_by.txt"
  val lines = getLinesFromFile(filePath)
  val firstLine = lines.head
  println(firstLine)
  val secondLine = lines(1)
  //println(secondLine)
  val secondLineSplit = secondLine.split(" ")
  val poetFullName = secondLineSplit(1) + " " + secondLineSplit(2)
  //is there a possibility to do it with less actions?
  println(poetFullName)

  val filterText = "woods"
  val filteredLines = for (line <- lines if line.contains(filterText)) yield line
  println(s"Lines containing $filterText")
  println(filteredLines.mkString("\n"))



}
