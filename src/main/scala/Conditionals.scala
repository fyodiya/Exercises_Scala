import scala.io.StdIn.readLine

object Conditionals extends App {
  //conditionals let us branch our code, take one of multiple paths

  //  val a = -400
  val a = readLine("Enter value of a(must be number)").toDouble //we will allow floating points as well

  // remember a could be coming from somewhere else or user input or database or somewhere
  if (a > 10) println(s"a is larger than 10, actually a is $a") // so nothing happens if a is not larger than 10

  if (a > 600) {
    //we could do lots of things
    println("Over 600")
    println(a)
  }

  //we can also do if else, show two paths
  if (a > 8) println(s"a is larger than 10, actually a is $a")
  else println("a is less or equal to 8")

  //if we need to do more work we can use curly braces for multiple instructions

  if (a > 9000) {
    println("Wow it is over 9000!")
    println(s"a is $a")
  } else {
    println("Sorry not quite 9000...")
    println(s"a is $a") //here of course we could have simplified our code by putting
  }
  //println(s"a is $a") here

  //we can keep branching actually
  if (a > 100) {
    val b = 33333 // b is local only within these inner curly bracers
    if (a > 500) println("Over 500") //so branch inside a branch
    else println("over 100 but less or equal to 500")
    println(s"WE can print b just for heck of it $b")
    //so b with 33333 is gone after this line
  } else println("less than or equal to 100")

  //
  //  println(b) //so b is only accessible to within that  {} block after a > 100
  val d = if (a > 10) 10 else a //so d is a capped at 10 otherwise it is the value of a
  println(d)

  //now let's determine whether a is even or odd (assuming it is integer first)
  if (a.toInt % 2 == 0) println(s"whole part of $a is even")
  else println(s"whole part of $a is odd")

  //so if you have 3 branches you want to explore we can chain the if else statements

  if (a > 50) {
    println(s"a is greater than 50, a is actually $a")
  } else if (a < 50) {
    println(s"a is less than 50, a is actually $a")
  } else {
    println(s"What do you know? a is exactly 50, just a double check a is $a") //what else could it be other than 50
    //but with multi branches it is easy to make a mistake
  }

  //if you have more than 3 or 4 branches you should consider pattern matching which is another way of branching

  //so Scala lets us do expression oriented programming
  val b = readLine("okay how about you give me a b?").toInt
  //  val minValue =  if (a < b) a else b //of course this covers a == b
  //so why is minValue double?
  //since minValue could possibly be also double (from a) it has to be double
  //if we wanted to be sure it is integer we could put it in parenthesis and cast to Integer
  val minValue =  (if (a < b) a else b ).toInt //of course this covers a == b
  println(s"out of $a and $b the smallest is $minValue")

}