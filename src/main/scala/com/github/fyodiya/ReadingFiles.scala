package com.github.fyodiya
import com.github.fyodiya.Utilities.getLinesFromFile

import java.io.File

object ReadingFiles extends App {
  println("Going to read some file")

  //let's check our current working directory because we need to know to have correct relative path

  println(System.getProperty("user.dir"))

  val filePath = new File (getClass.getClassLoader.getResource("two_roads.txt").getPath)
  //there are absolute locations specific to your computer like C:/directory/file.txt
  //there are relative locations relative to some reference point, like your current location
  //or location of your project folder
  //relative locations are more flexible when moving across computers
 // val filePath = "IdeaProjects/ScalaPlayGroundAugust2021/src/resources/two_roads.txt" //to get this path
  // we started at location indicated by println(System.getProperty("user.dir"))


  //  val lines = Utilities.getLinesFromFile(filePath) //since i am lazy i could import it
  val lines = getLinesFromFile(filePath)
  println(s"Cool we got a poem with ${lines.length} lines")
  println(lines.mkString("\n")) //so we put back the newline...

  //we can always get back the text file with the new lines
  val text = lines.mkString("\n") //so we get back the newlines
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