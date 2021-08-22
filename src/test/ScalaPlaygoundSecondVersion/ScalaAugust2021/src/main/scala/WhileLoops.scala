import scala.io.StdIn.readLine

object WhileLoops extends App {

println("Alice did")
  println("talk")
  println("talk")
  println("talk")
  //what should we do if we want to repeat the action lets say 50 times?
  //copying and pasting wouldn't be productive

  var i = 0
  //so while loops run while the condition is true
  while (i < 10) {
    println(s"Alice is talking when i is $i")
    //we must add one more thing
    i = i +1 //it's called "incrementing the counter"
    //same as i += 1
  }
//there is room for forever loops, in some applications

  //other loop examples
  var floor = 5 //it has to be a variable since condition is changing
  while (floor > 0 ) {
    println(s"Taking the elevator, now at the floor $floor")
    floor -= 1 //same as floor = floor - 1
  }
    println(s"Should be at the ground floor $floor")

 // while(true) {
 //   do something
    //ask for an exit condition
    //{
  //}

  var sum = 0.0 //or .toDouble
  while (sum < 1000) {
    val num = readLine(s"Enter any number, program will quit when sum is over 1000").toDouble
    sum += num //same as sum - sum + num
    println(s"New sum is $num")
  }

  var userInput = ""
  var counter = 0//we need to negate the check, so while userInput doesn't start with q
  //while (userInput != "Y") {
    while (userInput.startsWith("Y")) {
    //userInput = readLine("Do you want to quit? (Y/N)") //very strict, only "Y" will make the program quit
    counter += 1
    println(s"New counter value is $counter")
  }
print("Starting another loop for exercise")
  while (counter < 10 && userInput != "Exit") {
    counter += 1
    println(s"New counter value is $counter")
  }
//we have combined two conditions




}
