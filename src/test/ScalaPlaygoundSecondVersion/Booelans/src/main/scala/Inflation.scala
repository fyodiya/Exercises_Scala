object Inflation extends App {
  def inflationCalculator(startingPrice: Double, inflationPercentage: Double, targetPrice: Double): Unit = {
    //of course we can use formula
    var yearCounter = 0 //we need to return integer in the result of our method
    var currentPrice = startingPrice
    if (currentPrice < startingPrice) {
      return -1 //so called early return in functions
    }
    while (currentPrice < targetPrice) {
      currentPrice *= (1 + inflationPercentage / 100)
      yearCounter += 1
      println(s"after year $yearCounter  price is $currentPrice")
    }
    var isJobFinished = false
    if (currentPrice < targetPrice) {
      yearCounter = -1
      return yearCounter
    }
    isJobFinished = true
  }
  while (!isInstanceOf && currentPrice  < targetPrice)
    currentPrice



    }
    yearCounter //this is always returned with some results, it always comes last, not in the middle or somewhere else

    println(inflationCalculator(200, 4, 400))
  }


}