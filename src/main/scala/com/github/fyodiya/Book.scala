package com.github.fyodiya

import scala.xml.Elem

case class Book(category: String,title: String,author: String,year:String,price: Double){
  def toRow():String= s"$category,$title,$author,$year,$price"

  //serializer - converting our Case Class back to XML
  def toXML: Elem=
    <book category={category}>
      <title>{title}</title>
      <author>{author}</author>
      <yearMade>{year}</yearMade>
      <bookPrice>{price}</bookPrice>
    </book>
}
