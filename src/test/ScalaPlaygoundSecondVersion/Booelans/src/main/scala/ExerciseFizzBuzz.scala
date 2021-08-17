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







}
