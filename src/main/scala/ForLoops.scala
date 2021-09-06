object ForLoops extends App {
//we can do everything while loops but for loops offer us convenience
  //we use for loops when we know the exact number of repeated loops or steps

  for (i <- 0 to 5) { //to includes last number
    println(s"i is now $i")
  }
  //i will be gone here, not accessible
  //so code is cleaner

  for (i <- 0 until 5) { //until does not include last number
    println(s"i is now $i")
  }
  // we are reusing i, but its separated in both commands

val myName = "Valdis"
  for (c <- myName) {
    println(s"Current letter is $c")
  }
//for loops are suitable for going through anything that can be considered a sequence, incl. strings

  //there is a convention to use _ when value is not important
  for (_ <- 0 until 5) {

  }

  myName.foreach(println) //we are using saying for each individual member of myName to print it
for (char <- myName) println(char) //same command as the one above it
  //shorter syntax but the code is completely fine

  for (n <- Range(0,10)) {
    println(s"n is $n")
    // so Range gives us number on demand, in certain range
  }

  for (n <- Range(0,10,2)) {
    println(s"n is $n")}
  //we can also add a step to our range

  for (n <- 0 to 10 by 2) {
    println(s"n is $n")
  }
  //if we wouldn't want 10 we would have used UNTIL instead of TO

  for (n <- 20 to 0 by -4) {
    println (s"n is $n")
  }
  //using range is like using UNTIL

  //BY indicates step size, it could be negative or positive

  //for (n <- 0 to 10 by 0.5) we cannot use steps like that, we must use while loops
  //partial steps are not suitable for FOR LOOPS

 {
  var n = 0.0
  while (n <= 10) {
    println(s"n is $n")
    n += 0.5
    }
  }



}
