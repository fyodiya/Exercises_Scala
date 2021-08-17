object ExerciseFizzBuzz extends App {
//TODO create a Fizz Buzz program based on a children's game
  //for numbers from 1 to 100 included print FizzBuzz if number divided evenly by both 5 and 7
  //print FIZZ even number only divides by 9
  //BUZZ - by 7
  // print number if number does not divide by 5 or 7

for (i <- 1 until 100) {
  if ((i % 5 == 0) && (i % 7 == 0)) {
    println("FizzBuzz")
  }
   else {if (i % 9 == 0)
    {println("Fizz")
  }
  else if (i % 7 == 0) {
    println("Buzz")}
  else println("i")
  }
  if (i != 100) print(",")


}
 for (number <- 1 to 100) {
   var myText = ""

   if (number % 5 == 0) myText = "Fizz"
   if (number % 7 == 0) myText = "Buzz"
   if ((number % 5 != 0) && (number % 7 != 0)) myText = "FizzBuzz"
    if ((number % 5 == 0) && (number % 7 == 0))
      println(s"$number")



 }
//Range gives us numbers on demand
for (n <- Range(0,10)) {
  println(s"n is $n")
}

  //we can also add another step to range
  for (n <- Range(0,10,2)) {
    println(s"n is $n")
  }
//if we didn't want 10 we would add until instead of 2
  for (n <- 0 to 10 by 2) {
    println(s"n is $n")
  }

  for (n <- 20 to 0 by -4) {
    println(s"n is $n")
  }



}
