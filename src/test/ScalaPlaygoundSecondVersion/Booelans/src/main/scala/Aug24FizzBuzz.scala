object Aug24FizzBuzz extends App {
//TODO create an Array(String) continuing FizzBuzz values
   val myNumbers = (1 to 10).toArray

  //you can use either yield or map
  //but its better to create a helper function
  def getFizzBuzzText(n: Int) = {
    if (n % 5 == 0 && n % 7 == 0) "FizzBuzz"
    else if (n % 5 == 0) "Fizz"
    else if (n % 7 == 0) "Buzz"
    else s"$n"
  }
  val myFizzBuzz = for (n <- myNumbers) yield getFizzBuzzText(n)
  myFizzBuzz.foreach(println)


  val myFizzBuzzToo = myNumbers.map (n => getFizzBuzzText(n))
  myFizzBuzzToo.foreach(println)



}
