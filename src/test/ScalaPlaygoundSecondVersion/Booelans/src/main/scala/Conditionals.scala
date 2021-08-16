import scala.Console.println
import scala.Predef.println
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

 //ask for name
 //ask for how long they have worked
 //ask for monthly wage
 //calculate Xmas bonus if they have worked over 2 years
 //if more than 2 years bonus is +15%
 //if more than 5 years bonus is 1000 euros
}
