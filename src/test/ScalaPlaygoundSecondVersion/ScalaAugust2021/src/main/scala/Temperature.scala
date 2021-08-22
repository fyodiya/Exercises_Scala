object Temperature extends App {
  //write a function to calculate Fahrenheit from Celsius
  //f = 32 + C*9/5
  //test it with 36.6
  //test it with 37
  //test it with 48.5

  //name a function yourself, figure out the signature

  def temperatureResult (temperatureInCelsius: Double): Double = {
    val temperatureInFahrenheit = 32 + temperatureInCelsius*9/5
    return temperatureInFahrenheit
  }
  println(temperatureResult(36.6 ))
  println(temperatureResult(37))
  println(temperatureResult(48.5))

  //def Fahrenheit(c: Double) = println(s"Fahrenheit from $c C is ${32 + c * 9 / 5}")
  //def add(a: Int, b: Int) = {
  //val f = readLine("Please write an Celsius amount you want to convert to Farenheit").trim.toDouble


  def funnyString(prefix: String, mainText: String, multiplier: Int) :String= {
    prefix+mainText+multiplier
  } :String
  println(funnyString("ba","na",5 ))

  //a very thin wrapper around Math.pow
  def lazyPower(num: Double, power: Double=2):Double = Math.pow(num, power)
  println(lazyPower(5)) //so here 2 is given automatically
  println(lazyPower(5,3))
  //default values should come after the specified ones
  println(lazyPower())
  //so 10 to 2nd power is squared is 100


  val myFun: Int => Int = a => a*5 //alternated way of how to define the function
  println(myFun(10))
  //will give you 50)
  def myFunToo(n: Int) = n*5 //easier to follow syntax
  println(myFunToo(100))
  val storedResult = myFunToo(100)
  println(storedResult)



}
