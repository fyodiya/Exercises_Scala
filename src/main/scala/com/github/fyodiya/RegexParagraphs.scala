package com.github.fyodiya

object RegexParagraphs extends App {
val srcFile = "src/resources/61262-0.txt"
  val text = Utilities.getTextFromFile(srcFile)
println(text.length)

  //val paragraphs = text.split("\\r\\n\\r\\n")
   //we define each paragraph as two or more lines in it
//newLines are 2 characters - carriage return and line feed

  val paragraphs = text.split("(\\r\\n){2,}")
  //with this we group or match string and split it


  println(paragraphs.size)

  //println(text.slice(0,100))
  //text.slice(0,100).foreach(c => c.toInt)



}
