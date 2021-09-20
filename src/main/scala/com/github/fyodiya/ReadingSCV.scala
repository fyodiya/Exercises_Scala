package com.github.fyodiya

object ReadingSCV extends App {
  val srcFile = "src/resources/csv/veggie_prices_21.csv"
  val lines = Utilities.getLinesFromFile(srcFile)
  lines.slice(0,10).foreach(println)
//we want to get each value in a separate line, so we need to split
  //we can use split or yield
  val splitLines = lines.map(_.split(","))
  splitLines.slice(0,10).foreach(line => println(line.mkString(",")))

  def arrayToVeggie(arr:Array[String]):Veggie = {
    //the hard part with CSV is handling bad cases
    //you would want to add some error handling here
    Veggie(arr(0), arr(1), arr(2), arr(3), arr(4).toDouble, arr(5))
  }

 val veggieLines = splitLines.tail.map(line => arrayToVeggie(line))
  //we make some structure from our data

  val prices = veggieLines.map(_.price)
  println(s"Max price is ${prices.max}")

  val maxPricedItems = veggieLines.filter(_.price == prices.max)

  val sortedVeggies = veggieLines.sortBy(_.price)
  sortedVeggies.slice(0,10).foreach(println)

  //if we wanted the most expensive we could reverse the array
  //we could also slice it, but reversing it is much easier
  println("top 10 most expensive vegetables are:")
  sortedVeggies.reverse.slice(0,10).foreach(println)



}
