package com.github.fyodiya

object ExerciseVeggieAnalysis extends App {
  val srcFile = "src/resources/csv/veggie_prices_21.csv"
  val lines = Utilities.getLinesFromFile(srcFile)
  lines.slice(0, 10).foreach(println)
  //we want to get each value in a separate line, so we need to split
  //we can use split or yield
  val splitLines = lines.map(_.split(","))
  splitLines.slice(0, 10).foreach(line => println(line.mkString(",")))

  def arrayToVeggie(arr: Array[String]): Veggie = {
    //the hard part with CSV is handling bad cases
    //you would want to add some error handling here
    Veggie(arr(0), arr(1), arr(2), arr(3), arr(4).toDouble, arr(5))
  }

  val veggieLines = splitLines.tail.map(line => arrayToVeggie(line))

  println(s"there are ${veggieLines.length} items in our price list")

  //TODO get the most expensive apples - top5
  val onlyApples = veggieLines.filter(_.item == "apples")
  val applePrices = onlyApples.sortBy(_.price)
  println("Most expensive apples")
  applePrices.reverse.slice(0, 5).foreach(println)
  println("Less expensive apples")
  applePrices.slice(0, 5).foreach(println)
  val appleItemPrice = onlyApples.map(_.price)
  println(s"Apple max price is ${appleItemPrice.max}")
  println(s"Apple min price is ${appleItemPrice.min}")

  //TODO get 5 the least expensive apple entries
  //TODO get the average price for potatoes

  //TODO get the average price for potatoes by year
  //val lettuce = veggieLines.filter(_.item.contains("lettuce"))
  //lettuce.slice(0,5).foreach(println)
  val onlyLettuce = veggieLines.filter(_.item == "lettuce")
  //val lettuceYear = onlyLettuce.filter(_.date)
  val lettucePrices = onlyLettuce.map(_.price)
  val averageLettucePrice = (lettucePrices.sum / onlyLettuce.length) - (lettucePrices.sum / onlyLettuce.length % 0.01)
  println(s"The average price of lettuce is $averageLettucePrice")

  //the idea is to group our data by year
  //the idea is to create a new column for the year, and then use group by function
  val numbers = (0 to 12).toArray
  val groupedNumbers = numbers.groupBy(_ % 4) // so we group numbers by their reminder when divided by 4
  for ((key, value) <- groupedNumbers) {
    println(s"Reminder $key")
    println(s"Values")
    println(value.mkString(","))
  }

  val groupedByCategory = veggieLines.groupBy(_.category)
  val topCount = 5
  for ((key, value) <- groupedByCategory) {
    println(s"Category $key")
    println(s"Top $topCount Most expensive")
    val sortedValues = value.sortBy(_.price)
    println(sortedValues.reverse.slice(0,topCount).mkString("\n"))
  }

  //so we could group by year if we had it well we could do it a hot run just need year from split

  val groupedByYear = onlyLettuce.groupBy(_.date.split("-").head) //we group by year which we extract on the run
  for ((key, value) <- groupedByYear) {
    println(s"Category $key")
    println(s"Top $topCount Most expensive")
    val sortedValues = value.sortBy(_.price)
    println(sortedValues.reverse.slice(0,topCount).mkString("\n"))
    val prices = value.map(_.price)
    println(s"For year $key lettuce prices ranged from ${prices.min} to ${prices.max}")
  }
  //Mappings do not guarantee specific order we could use sorted Map we can try
  import scala.collection.SortedMap
  //https://stackoverflow.com/questions/3074118/how-do-i-convert-a-mapint-any-to-a-sortedmap-in-scala-or-a-treemap
  val sortedByYear = SortedMap(groupedByYear.toArray:_*) //so this trick recasts any map to sortedmap
  for ((key, value) <- sortedByYear) {
    println(s"Category $key")
    println(s"Top $topCount Most expensive")
    val sortedValues = value.sortBy(_.price)
    println(sortedValues.reverse.slice(0,topCount).mkString("\n"))
    val prices = value.map(_.price)
    println(s"For year $key lettuce prices ranged from ${prices.min} to ${prices.max}")
  }

}