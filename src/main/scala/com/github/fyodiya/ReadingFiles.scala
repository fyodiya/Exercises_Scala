package com.github.fyodiya

import java.io.File
import scala.io.Source

object ReadingFiles extends App {
  println("We are going to read some files")

  //let's check our current working directory because we need to know to have correct relative path

  println(System.getProperty("user.dir"))

  val filePath = new File (getClass.getClassLoader.getResource("two_roads.txt").getPath)
  //there are absolute locations specific to your computer like C:/directory/file.txt
  //there are relative locations relative to some reference point, like your current location
  //or location of your project folder
  //relative locations are more flexible when moving across computers
 //absolute locations should be avoided

val relativePath = "src/resources/two_roads.txt"
  // we started at location indicated by println(System.getProperty("user.dir"))

  def getTextFromFile(srcPath:String):String = {
    val bufferedSource = Source.fromFile(srcPath) //we have a source stream, but it could also be network stream
    val textFromFile = bufferedSource.mkString //we transfer this stream until it ends into lines
    bufferedSource.close //lines - we define the ending character or next line with \n
    textFromFile}

  //val lines = Utilities.getLinesFromFile(filePath) //I could import it to save some work or time
  val lines = Utilities.getLinesFromFile(filePath.toString)
  println(s"Cool we got a poem with ${lines.length} lines")
  println(lines.mkString("\n")) //so we put back the newline...

  //we can always get back the text file with the new lines
  val text = lines.mkString("\n") //thus we get back newlines
  //  print(text)

  val firstLine = lines.head //same as lines(0)

  val firstLineSplit = firstLine.split("by")
  println(firstLineSplit.mkString(","))
  val poemName = firstLineSplit.head.trim //we are guaranteed to have first part
  println(s"Poem is $poemName")
  //the next line requires that by exists so we add safety check for index
  val poetName = if (firstLineSplit.length > 1) firstLineSplit(1).trim else "no poet found"

  println(s"Poet is $poetName")

  //now lets filter some lines which start with 'And'

  val filterText = "And"
  val filteredLines = for (line <- lines if line.startsWith(filterText)) yield line
  println(s"Lines starting with $filterText")
  println(filteredLines.mkString("\n"))

  //we can also use filter to achieve same thing as yield
  val filteredLinesToo = lines.filter(_.startsWith(filterText))
  println(s"Lines starting with $filterText")
  println(filteredLinesToo.mkString("\n"))


}