import scala.io.StdIn.readLine

object Factorials extends App {
  //TODO write code to calculate Factorial from user entry

  val number = readLine ("Please enter a whole number for which you want to get a factorial").trim.toString
  println(s"we will calculate factorial of number $number")
  var result = 1
  for (n <- 2 to number) result *=n
  //same as result = result * n
  println(s"Factorial of $number is $result")

  {
    var resultToo = number
    for(n <- number -1 to 2 by -1) resultToo *= n
    println(s"Factorial of $number is $resultToo")
    //we could use while loop or also for loop
  }

  var addResult = 0 //for addition we would add zero
  for (n <- 1 to number) addResult += n
  println(s"sum of numbers from 1 to $number is $addResult")


  //factorial of 1 is 1
  //of 2 is 1*2
  //of 3 is 1*2*3
  //of 4 is 1*2*3*4
  //for larger numbers we need a larger number type

  //we will need some variables to store our intermediate results
  //and we will add a loop to multiply all the numbers together
  //then we will simply print out the results







}
