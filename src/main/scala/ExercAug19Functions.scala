object ExerciseAug19Functions extends App {
  def temperatureConverter (Celsius: Double) : Double = {
   val Fahrenheit = 32 + Celsius*9/5
    return Fahrenheit - (Fahrenheit % 0.01)
  }
  println(temperatureConverter(36.6 ))
  println(temperatureConverter(37))
  println(temperatureConverter(48.5))

}
