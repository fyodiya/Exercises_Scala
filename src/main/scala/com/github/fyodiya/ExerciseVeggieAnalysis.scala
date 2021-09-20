package com.github.fyodiya

object ExerciseVeggieAnalysis extends App {
  val srcFile = "src/resources/csv/veggie_prices_21.csv"
  val lines = Utilities.getLinesFromFile(srcFile)
  lines.slice(0,10).foreach(println)
  //we want to get each value in a separate line, so we need to split
  //we can use split or yield
  val splitLines = lines.map(_.split(","))
  splitLines.slice(0,10).foreach(line => println(line.mkString(",")))

  def arrayToVeggie(src:Array[String]):Veggie = {
    //the hard part with CSV is handling the bad cases
    Veggie(arr(0), arr(1), arr(3), arr(4).toDouble, arr(5))
  }
  val veggieLines = splitLines.tail.map(line => arrayToVeggie(line))

  println(s"there are ${veggieLines.length} items in our price list")

  //TODO get the most expensive apples - top5
  //TODO get 5 the least expensive apple entries
  //TODO get the average price for potatoes

  //TODO get the average price for potatoes by year
  val lettuce = veggieLines.filter(_.item.contains("lettuce"))
  lettuce.slice(0,5).foreach(println)
}
