object Functions extends App {
  println("Let's eat!")
  //    println("Eating potatoes")
  //    println("Eating potatoes")
  //    println("Eating potatoes")
  //
  //    for (_ <- 0 until 5) println("Eating potatoes again and again")

  //so if we have more than one task over multiple lines do we hav to copy and paste
  //if they always go together?
  //    println("Sitting down at a table")
  //    println("Picking up the fork")
  //    println("Eating potatoes")
  //
  //    for (_ <- 1 to 3) {
  //        println("Sitting down at a table")
  //        println("Picking up the fork")
  //        println("Eating potatoes")
  //    }

  //i can encapsulate some actions into a functional block - function
  //I declare a function
  def eat() = {
    println("Sitting down at a table")
    println("Picking up the fork")
    println("Eating potatoes")
  }
  //so we can now abstract our act of eating into a single function/(also called method)
  for (_ <- 0 until 3) eat() //here I call function eat 3 times
  println("Really full now")
  println("resting")
  eat() //here I call eat one time

  //functions become even more powerful when we give them parameters, we pass arguments
  //second parameter has the default value of "William"
  def orderFood(dish: String, waiter: String = "William") = {
    println(s"Calling waiter $waiter")
    println(s"Please, bring us $dish")
    println("We are hungry")
  }

  orderFood("potatoes")
  orderFood("bananas")
  orderFood("bananas", "Voldemars")

  //so Unit means that we are not getting any values returned from our function

  //it is fine to make one line functions if they simplify something
  //    def add(a: Int, b: Int) = println(s"a+b=${a+b}")
  def add(a: Int, b: Int) = {
    val result = a + b //this result will stop living as a value once function ends
    println(s"Wow $a+$b=$result")
    result //so whatever is in the last line of function will be returned automatically
    //no need for return, notice comment does not count, the line above is returned
  }

  val myResult = add(2,3) //
  println(s"I can now use result of add after it is done $myResult")

  //I can compose function into function, keep using them
  val bigResult = add(100, add(10,20)) //so inner add will be calculated first
  println(s"Big result $bigResult")

  def multiply(a: Int, b: Int) = a*b //really short but not very useful because we already have *

  val multiAdd = add(multiply(10,2), add(5,6)) //so inner add runs first, then multiply, then outer add
  println(multiAdd)

  //we can have different data types going in and out
  def lengthOfText(text: String) = text.length // another useless function because we already have it in Scala

  val myTextLength = lengthOfText("Valdis")
  println(myTextLength)

  //lets make our own round function, because the built in round only worked with whole numbers
  //default precision will be 0
  def myRound(n: Double, precision: Int=0):Double = {
    val multiplier = Math.pow(10, precision)
    //        val multiplied = (n*multiplier).round
    ////        println(multiplied)
    //        val result = multiplied / multiplier
    //        println(result)
    //        result//i could have made a result out of this
    (n*multiplier).round/multiplier
    //        0.0 //so my function works .. sort of I have a dummy function
  }

  println(Math.PI)
  println(myRound(Math.PI, 2))
  println(myRound(Math.PI, 4))
  println(myRound(Math.PI)) //using the default precision of 0, will be we get 3 ?
  //we can do a simple test

  println(myRound(10.23325, 1))
}