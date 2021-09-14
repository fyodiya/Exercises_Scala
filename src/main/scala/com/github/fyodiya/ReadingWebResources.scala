package com.github.fyodiya

object ReadingWebResources extends App {

  val url = "https://www.gutenberg.org/ebooks/61262-0.txt"

  import scala.io.Source
  val html = Source.fromURL("https://www.gutenberg.org/ebooks/61262-0.txt")
  val s = html.mkString
  val destinationFolder = "src/resources"

  println(s.slice(0,100))

  //val t0 = System.nanoTime()
  //val myText = Utilities.getTextFromWeb(url)
  //val t1 = System.nanoTime()
  //val dataTime = (t1-t0)/1_000_000
  //println(s"It took the system $dataTime miliseconds to download from the $url")

  val destinationFile = "src/resources/61262-0.txt"
  val fileName = url.split("/").last
  val destinationFilePath = s"$destinationFolder/$fileName"

  println(s"Starting to download from $url")
  val t0 = System.nanoTime()
  val myText = Utilities.getTextFromWeb(url)
  val t1 = System.nanoTime()
  val dataTime = (t1-t0)/1_000_000
  println(s"It took the system $dataTime miliseconds to download from the $url")
println(s"saving to $destinationFolder")
  Utilities.saveText(destinationFolder, myText:String, true)


}
