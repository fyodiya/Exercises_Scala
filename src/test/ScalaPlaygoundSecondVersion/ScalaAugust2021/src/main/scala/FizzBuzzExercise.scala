object FizzBuzzExercise extends App {

    // create a FizzBuzz program based on children's game I think from Britain
    //for numbers 1 to 100 (included!)
    //print FizzBuzz if number divides evenly by both 5 and 7
    //print Fizz if number only divides by 5
    //print Buzz if number divides by 7
    //print number if number does not divide by 5 or 7
    //so something like this 1,2,3,4,Fizz,6,Buzz,..... 34,FizzBuzz,36,....
    //printing can be done with number on new line like we have been doing
    for (number <- 1 to 100) {
      if (number % 5 == 0 && number % 7 == 0) {
        print("FizzBuzz") //print does not create a new line unlike println
      }
      else if (number %5 == 0) {
        print("Fizz")
      } else if (number %7 == 0) {
        print("Buzz")
      } else {
        print(s"$number")
      }
      if (number != 100) print(",")
    }

    //it is possible to make a mistake if you switch order of operations
    //this will not work as expected
    //  for (number <- 1 to 100) {
    //    if (number % 5 == 0) {
    //      println("Fizz") //print does not create a new line unlike println
    //    }
    //    else if (number % 7 ==0) {
    //      println("Buzz")
    //    } else if (number % 5 == 0 && number % 7 == 0) { //this will never print...think about why?
    //      //because check for division by 5 only happens first...
    //      println("FizzBuzz")
    //    } else {
    //      println(s"$number")
    //    }
    //  }


    //another approach (not very Scala like) is to build a string up from nothing
    for (number <- 1 to 100) {
      var myText = ""

      if (number % 5 == 0) myText = "Fizz"
      if (number % 7 == 0) myText += "Buzz" //this is not efficient on long strings same as myText = myText+"Buzz"
      if ((number % 5 != 0) && (number % 7 != 0)) myText = s"$number"

      println(myText)

    }

    //Anete's solution fixed
    for (number <- 1 to 100) {
      if ((number % 5 == 0) && (number % 7 == 0)) println("FizzBuzz")
      if (number % 7 == 0 && number % 5 != 0) println("Buzz")
      if (number % 5 == 0 && number % 7 !=0 )  println("Fizz")
      if ((number % 5 != 0) && (number % 7 != 0)) println (s"$number")
    }
    //above solution would be better suited when the check are not related to each other
}