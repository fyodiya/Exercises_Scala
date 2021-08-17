import scala.io.StdIn.readLine

object WhileLoops extends App {
println("Alice did")
  println("talk")
  println("talk")
  println("talk")

  var i = 0
  while (i < 10) {
    println(s"talking when i is $i")
  i = i + 1 //increment the counter
  i+=1 //increment the counter same as i = 1+1
  }

  //so while loops run while the conditions in parenthesis are true
var floor = 5 //for while loops our condition has to ba variable since we're going to be changing
  while (floor > 0) {
    println(s"Taking the elevator now at the floor $floor")
  floor -= 1 //which is the same as floor -1
  }
  println(s"Should be at ground floor $floor")

//there might be occasions when we create forever loops
while(true) {
  //do something
  //ask for some exit condition
  //exit on that condition
}

var sum:Double = 0
while (sum < 1000) {
  val num = readLine("Enter any number, program will quit when sum is over 1000").toDouble
  sum += num //same as sum = sum + num
  println(s"New sum is $sum")
}

var userInput = ""
var counter = 0
while (userInput.toUpperCase.startsWith("q")) {
  //we need to negate the check so while userInput does not start with q
  //while (userInput != "Y" { //very strictly only "Y will quit
  // while (userInput.startsWith("Y" { now anything text input starting with Y or y will quit )"
  counter += 1
  userInput = readLine("Do you want to quit? Y/N")
  counter += 1
  println(s"new counter value is $counter")
  userInput = readLine("Do you want to quit? Y/N")
}

//we can also combine conditions inside loop check
  println("Starting another loop")



}