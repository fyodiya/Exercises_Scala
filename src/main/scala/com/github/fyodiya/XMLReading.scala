package com.github.fyodiya

import scala.xml.XML

object XMLReading extends App {
  val srcFile = "src/resources/xml/books.xml"

  val xml = XML.loadFile(srcFile) //so val xml is points to the root element of this particular document

  //TODO create case class for the books
  //Read the books from the xml put them inside the case file, keep all the attributes and tags

  //TODO print the book objects(created from case class) in Ascending order of prices
  val bookNodes = xml \ "book" // we get some sequence of nodes

  //deserializer - meaning converts from XML into our local format
  def nodeToBook (node: scala.xml.Node):Book = {
    val category: String = node.attribute("category").getOrElse("No category").toString
    val title: String = (node \ "title").text
    val author: String  = (node \ "author").text
    val year:String = (node \ "year").text
    val price: Double = (node \ "price").text.toDouble
    Book(category, title, author, year, price)
  }

  val books = bookNodes.map(nodeToBook) //so map is our loop
  //of course we could do it with for (book <- bookNodes) yield nodeToBook(book)
 //TODO  books.sortBy(_.price).foreach(println) - resolve

  val destFile = "src/resources/xml/newBooks.xml"

 val newBookNodes = books.map(_.toXML)

  //unanswered how to add newlines between elements here
  val parentNode = <myBookCollection>
    {newBookNodes}
  </myBookCollection>

  XML.save(destFile, parentNode, enc = "utf-8", xmlDecl = true)

  //If you want the function to match in cases like these, you can match against
  //a sequence of nodes instead of a single one. The pattern for "any sequence"
  //of XML nodes is written `_*'. Visually, this sequence looks like the wildcard
  //pattern (_) followed by a regex-style Kleene star (*). Here is the updated
  //function that matches a sequence of sub-elements instead of a single sub-
  //element:
  def proc(node: scala.xml.Node): String =
    node match {
      case <title>{contents @ _*}</title> => "It's a title: " + contents
      case <author>{contents @ _*}</author> => "It's an author: " + contents
      case <year>{contents @ _*}</year> => "It's a year: " + contents
      case <price>{contents @ _*}</price> => "It's a price: " + contents
      //      case <PCDATA>{contents @ _*}</PCDATA>=> "It's a PCDATA: " + contents //FIXME how to extract PCDATA
      case _ => "It's something else."
    }

  val bookElem = bookNodes.head //first book
  // so we will go through all children in the first book
  for (child <- bookElem.child) { //I would have preferred children instead of node.child since it is plural
    println("Processed: " + proc(child))
    println("Node label is: " + child.label)
    //we could use child.label to yield different things
  }
}