object MapAndFilterCollections extends App {

  val numbers = (0 to 20).toArray
  val divideBy5 = for (n <- numbers if n % 5 == 0) yield n
  println(divideBy5.mkString(","))

  //we are actually using filter
  val divideBy4 = numbers.filter(n => n %4 == 0)
println(divideBy4.mkString(","))

  val bigNumbers = numbers.map(n => n*100)
  println(bigNumbers.mkString(","))
  //YIELD is also using MAP underneath it

  //how would we make squares out of only odd numbers?
  //we could use yield or map filter
  val addSquares = for (n <- numbers if n % 2 == 1) yield n*n
  println(addSquares.mkString(","))
  val addSquaresAgain = numbers.filter(_ % 2 == 1).map(n => n*n) //we need to use full syntax here
  println(addSquaresAgain.mkString(","))

  val just3 = addSquares.slice(0,3)
  just3.foreach(n => println(n)) //full syntax
  just3.foreach(println(_)) // shorter syntax if we need to use the item only once
  just3.foreach(println) //even shorter syntax used if the function we are giving it uses

  def prettyPrint (number:Int) = println(s"The number is $number")

  just3.foreach(n => prettyPrint(_))
  just3.foreach(prettyPrint)

}
