import Conditionals.a

import scala.Console.println
import scala.io.StdIn.readLine

object Conditionals extends App {
  //conditionals let us branch our code, take one of multiple paths

  val a = 4000
  if (a > 10) println("a is larger than 10")

  //we can also do if, else, choosing two paths instead of 1

  if (a > 10) println(s"a is larger than 10, actually a is $a")
  else println(s"a is less or equal to 9")

 // val a = readLine ("Enter value a (must be number)").toDouble

  //if we need to do more work we can use curly braces for multiple instructions
  if (a>9000) {
    print("Now it is over 9000!")
    println(s"a is $a")
  }
  else {
    println("Sorry, it's less than 9000")
    println(s"a is $a")
  }

// we can keep branching

  // TODO finish the task
  // if (a > 100) {
    val b = 33333 //defined only inside these curly braces
    if (a>500) println("over 500")
    //else (a <500) println("over 100 but less than 500")}
}

private val d = if (a > 10)  10 else a // so d is capped at 10 otherwise its a value of 10
println(d)

if (a.toInt % 2 == 0) println(s"whole part of $d is even")
else println(s"$d is odd number")

if (a > 50) {
  println(s"a is greater than 50, so a is actually $a")}
  else if (a < 50) {
    println(s"a is less than 50, so a is actually $a")
  } else {
    print(s"a is exactly 50, just to double check it: $a")
  //with multi branches it's easy to make a mistake
}

val b = readLine("ok, give me a b").toInt
val minValue = if (a < b) a else b //of course it covers a == b
println(s"out of $a and $b the smallest is $minValue")

//why is minValue in Double?
//since minValue could possibly be a double (from a), it has to be a double
//if we wanted to be sure its integer we should put it in parenthesis and cast to integer




