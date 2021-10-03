package com.github.fyodiya

object ParsingText extends App {
  val srcFolder = "src/resources"
  val files = Utilities.getListOfFiles(srcFolder)
  files.foreach(println) //so we are printing each File
  //so now how could we get a list of files from our list which only start with digits?
  //so we can get the file name
  println(files.head.getName)

  //so let's think what would be the idea to only get files that start with digits

  //so we could filter or yield files from our files list and check if the name starts with a digit

  //but how

  //short way would be as follows
  val numericFiles = files.filter(_.getName.head.isDigit)
  println(numericFiles) //so our List only has one item left

  //the above is nice for simple cases but not very flexible


  //this is universal filter using regular expression
  val numRex = "^[0-9].*" //^ start of a string [0-9] any digit, .* means anything many times or nothing
  val filteredFiles = files.filter(_.getName.matches(numRex))
  println(filteredFiles)

  //same as above with yield
  val filteredFilesToo = for (file <- files if file.getName.matches(numRex)) yield file
  println(filteredFilesToo)

  val stopFiles = Utilities.getListOfFiles(srcFolder, "^stop.*")
  println(stopFiles)

}
