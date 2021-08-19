object Exercise19OfAugust extends App {

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

}

