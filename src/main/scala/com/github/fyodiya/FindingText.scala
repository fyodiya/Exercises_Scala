package com.github.fyodiya

object FindingText extends App {

  val src = "src/resources/two_roads.txt"
  val lines = Utilities.getLinesFromFile(src)
  val roads = lines.filter(_.contains("road"))
  val indexes = lines.zipWithIndex.filter(_._1.contains("road")).map(_._2)
roads.foreach(println)

  indexes.foreach(println)

//  val triples = lines zip lines.slice(1,lines.length).zip(lines.slice(2,lines.length))
  val triples = lines.lazyZip(lines.slice(1,lines.length)).lazyZip(lines.slice(2,lines.length)).toArray
triples.foreach(println)

  val quads = "kartupelis".lazyZip(Range(0,15)).lazyZip(0 to 16).lazyZip(Array(3,5,6,8,9,20)).toArray
println(quads.length)
  quads.foreach(println)

  val alsoQuads = "kartupelis".lazyZip(Range(0,15)).lazyZip(40 to 16 by -2).lazyZip(lines.slice(2, lines.length)).toArray
  println(alsoQuads.length)
  alsoQuads.foreach(println)

  val anotherQuads = "kartupelis".lazyZip(Range(0,15)).lazyZip(40 to 16 by -2).lazyZip(Array("kafe", "art")).toArray
  println(anotherQuads.length) //should be -4, because it's the shortest of sequences
  anotherQuads.foreach(println)

  //going through lines with indexes we have to be careful not to go below 0
  println(lines.last, lines(lines.length-1))
  //println(lines(lines.length)) - array is out of bounds

//EXTRACTING A WHOLE PARAGRAPH


}
