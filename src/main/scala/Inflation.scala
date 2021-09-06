object Inflation extends App {
  //of course for this we could just use a formula
  //we can make a little helper function
  def nextYear(currentPrice: Double, inflationPercentage: Double ): Double = currentPrice * (1 + inflationPercentage / 100)

  def inflationCalculator(startingPrice: Double, inflationPercentage: Double, targetPrice: Double): Int = {
    var yearCounter = 0
    var currentPrice = nextYear(startingPrice, inflationPercentage)
    var isJobFinished = false //another common technique is to create extra flags

    if (currentPrice < startingPrice) { //equal price means we stagnate, less means we never reach target
      //we would like to return -1
      yearCounter = -2
      //        return yearCounter //this is possible in Scala but discouraged to use early return
      isJobFinished = true //this is a bit ugly but it works
    } else if (currentPrice == startingPrice) {
      println("Stagnation!")
      yearCounter = -1 //so we can code negative returns
      isJobFinished = true
    }
    while (!isJobFinished && currentPrice < targetPrice) {
      //      currentPrice *= (1 + inflationPercentage / 100) // same as currentPrice = currentPrice * (inflationPercentage*100)
      currentPrice = nextYear(currentPrice, inflationPercentage)
      yearCounter += 1 //one has passed same as yearCounter = yearCounter + 1
      println(s"After year $yearCounter price is $currentPrice")
    }

    yearCounter //this is always returned with some value
  }

  inflationCalculator(200, 8, 400)

  //this should take roughly 18 years if I remember my rule of 72 correctly
  //  println(inflationCalculator(200, 4, 400))
  //what do we do if we can expect negative inflation?
  //we want to return - 1 when we have deflation
  println(inflationCalculator(150, -0.7, 200))
  println(inflationCalculator(80, 0, 190))

}