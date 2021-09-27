package com.github.fyodiya

import scala.xml.XML

object XMLWork extends App {
val srcFile = "src/resources/books.xml"
  val xml = XML.loadFile(srcFile)
  println(xml)

  val books = xml \ "book"
  //we get some sequence
  print(books)

  for (book <- books) {
    val category = book.attribute("category").getOrElse("No category")
    val author = book \ "author" //potentially we could have few authors here
    val title = book \ "title"
    val price = (book \ "price").text.toDouble

    //println(s"Book $title is written by $author")

    println(s"Book: ${title.text} written by ${author.text} priced at $price in category: $category")



  }
}
