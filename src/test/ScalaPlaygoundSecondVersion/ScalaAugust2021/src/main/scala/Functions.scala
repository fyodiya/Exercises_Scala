object Functions extends App {

  println("Let's eat")
  println("eating potatoes")
  println("eating potatoes")
  println("eating potatoes")

  for (_ <- 0 until 5) println("Eating potatoes again and again")

  println("Sitting down at the table")
  println("Picking up the fork")
  println("Eating potatoes")
  //if we repeat one task multiple tasks or if multiple tasks go one after another
  for (_ <- 1 to 3) {
    println("Sitting down at the table")
    println("Picking up the fork")
    println("Eating potatoes")
  }

  def eat () = {
    println("Sitting down at the table")
    println("Picking up the fork")
    println("Eating potatoes")
  }

//so we can now abstract our act of eating into a single function (also called METHOD)
  for (_ <- 0 until 3) eat
  println ("Really full now after all that eating")
  println("Resting, getting hungry again")
  eat()

  //with functions we can abstract another way, we can solve more difficult problems
  //also we can provide documentation if our function names are meaningful

  def orderFood(dish: String, waiter: String = "William") = {
    println("Calling waiter")
    println(s"Please bring us $dish")
    println("We are very hungry")
  }
  orderFood("potatoes")
  orderFood("bananas")
  orderFood("bread", "Voldemars")
  //Unit means that we are not getting any values returned from our function

  //it's ok to make one-line functions, if they simplify something
  //def add(a: Int, b: Int) = println(s"a+b=${a+b}")
  def add(a: Int, b: Int) = {
    val result = a + b //this result will stop living as a value once function ends
    println(s"wow, a + b = $result")
    result //whatever is in the last line of function will be returned automatically, no need to return
  }
  val myResult = add(2,3)
  //result will be available for the outside use
  println(s"I can now use result of add after it is done $myResult")
  //we are passing along some parameters

  val bigResult = add(100, add(10,20)) //I can compose function inside the other function
  //inner part will be calculated first
  println(s"bigResult is $bigResult")

  def multiply(a: Int, b: Int) = a+b //really short function, but not very useful, because we already have multiplication

  val multiAdd = add(multiply(10,2), add(5,6))
  println(multiAdd)
  //these functions will pick up any mistakes
  //inner side runs first, than it's multiplying, than outer addition

  def lengthOfText(text: String) = text.length //useless function, because it's already built-in in Scala
  val myTextLength = lengthOfText("Valdis")
  println(myTextLength)

  //let's make our own round function, because the built-in one only works for whole numbers
  def myRound(n: Double, precision: Int) = {
    val multiplier = Math.pow(10, precision)
    val multiplied = (n*multiplier).round
//    0.0 //so we make it double
    //println(multiplied)
    //val result = multiplied / multiplier
    //println(result)
    //result
    (n*multiplier).round/multiplier
  }
  println(Math.PI)
  println(myRound(Math.PI, 2))
  println(myRound(Math.PI, 4))
  //we're testing our function
//it works, but only for 3.14
  println(myRound(10.23325, 2))




println(myRound(3.14159, 2))





  //we pass information to these functions














}
