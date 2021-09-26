package com.github.fyodiya

object ExercisePrideAndPrejudice extends App {
//download file with scala instead of by hand
  //save to src/resources
  //read,
  //extract all years (which are 4 digits long)
  //extract all words with capital letters

  //extra challenge - words which are not first in a sentence

  val url = "https://www.gutenberg.org/files/1342/1342-0.txt"
  val fileName = url.split("/").last //so this will work even if there is nothing to split
  val destPath = s"src/resources/$fileName"

  println(s"Will check if $destPath exists")
  println(Utilities.isFileThere(destPath))
  println(Utilities.isFileThere("src/resources/61262-0.txt"))

  if (!Utilities.isFileThere(destPath)) {
    println(s"No $destPath we need to download from $url")
    val text = Utilities.getTextFromWeb(url)
    //just notice this could take a bit so this is called blocking call, you cant proceed until you are finished
    Utilities.saveText(destPath, text)
  } //we could add else but here we will save and then load it

  val lines = Utilities.getLinesFromFile(destPath) //unless something went wrong with my HardDrive or SSD or Internet I should have the source
  val text = lines.mkString("\n")



}
