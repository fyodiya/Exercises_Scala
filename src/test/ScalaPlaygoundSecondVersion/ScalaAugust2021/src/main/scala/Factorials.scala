import scala.io.StdIn.readLine

object Factorials extends App {
 //code to calculate factorial from user entry

  val number = readLine ("please enter a whole number for which you want the factorial to be calculated").trim.toInt
//factorial of q is, of 2 is 1*2, OF 3 IS 1*2*3, OF 4 IS 1*2*3*4
  //we could use while loop or we could use for loop as well
 //for truly large numbers we will need a bigger number type
  println(s"Will calculate the factorial of number $number")
  var result = 1
  for (n <- 2 to number) result += n //same as result = result + n
    //we will start with 1, not 0 because than it would be only zeros
  println(s"Factorial of $number is $result")

//we could go the other way, too
  var resultToo = number
  for (n <- number to 2 by -1) resultToo *= n
  println(s"factorial for $number is $resultToo")

  var resultAgain = 1
  var n = 2
  while (n < number) {
    resultAgain *= n
    n += 1
  }
  println(s"Factorial again of $number is $resultAgain")

  var addResult = 0 //for addition we will do 0
  for (n <- 1 to number) addResult += n
  println(s"Sum of numbers from 1 to $number is $addResult")
  // there is a Gauss formula for that
  println((1  to number).sum)


  //more code isn't necessarily easier to read

}