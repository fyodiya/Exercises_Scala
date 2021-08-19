object Functions extends App {

  println("Let's eat!")
  println("eating potatoes.")
  println("eating potatoes.")
  println("eating potatoes.")

  for (_ <- 0 until 5) println("Eating potatoes again and again.")

  println("Sitting at the table.")
  println("Picking up fork.")
  println("Eating potatoes.")
//one task is repeated multiple times, by the tasks are fone one by one altogether

  for (_ <- 1 to 3)({
    println("Sitting at the table.")
    println("Picking up fork.")
    println("Eating potatoes.")
  })


  def eat() = {
    println("Sitting at the table.")
    println("Picking up fork.")
    println("Eating potatoes.")
  }
  for (_ <- 0 until 3) eat()

//we have defined EAT
//we see a structure now, structure of that action or process

  for (_ <- 0 until 3) eat()
  print("Really full now.")
  println("Reasting.")
  eat()

def orderFood(dish: String, waiter: String="William") = {
  println(s"Calling the $waiter.")
  println(s"Please, bring us $dish")
  println("We are hungry!")
}//we have defined the second parameter

  orderFood("potatoes")
  orderFood("bananas")
  //we're customizing our function
  orderFood("bananas", "Valdis")

  //we have to define what type of data we have
  //functions are our building blocks, that give our code the structure

  //Unit means that we are not getting any values returned from our function

  //it's fine to make one line functions, if they simplify the code
  //def add(a: Int, b: Int) = print(s"a+b=${a+b}")

  //another way of previous line
  def add(a: Int, b: Int): { //must be made into Int somehow
    val result = a+b
    println(s"Wow, $a + $b = $result")
    result //so whatever is in the last line of function will be returned automatically
  //no need for return
  }
  val myResult = add(2,3)
  println(s"I can now use result of add after it is done $myResult")
//I can compose this function into function
  val bigResult = add(10,20) //so inner add will be calculated first
  println(s"Big result $bigResult")

  def multiply(a: Int, b: Int) = a*b //really short but not very useful, becaus ewe already have 8

  val multiAdd = add(multiply(10,2), add(5,6))
  println(multiAdd)

  def myTextLength(text: String): Int = text.length //another useless function, we already have it
  print("myTextLength")

  //let's make our own round function, built-in round works only with whole numbers
  def myRound(n: Double, precision: Int):Double = {
   val multiplier = Math.pow(10, precision)
    val multiplied = (n*multiplier).round
    (n+100).round/100
    val result = multiplied /100
    println(result)
//let's make it short
    (n*multiplier).round/multiplier

  }

  println(Math.PI)
  println(myRound(Math.PI, precision = 2))
  println(myRound(Math.PI, precision = 4))
  println(myRound(Math.PI, precision = 3)) // a way of managing complexity

  println(myRound(10,23325))

  // we can do a single test
}
