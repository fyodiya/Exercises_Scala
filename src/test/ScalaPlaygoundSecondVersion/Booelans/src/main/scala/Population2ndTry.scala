object Population2ndTry extends App {

  println("Function to calculate city growth")

  def nextYear (p0: Int, percentage: Double, pDelta: Int, targetPopulation: Int): Double = p0 + pDelta + percentage/100

  def getCityYear(p0: Int, percentage: Double, pDelta: Int, targetPopulation: Int): Unit = {
    var yearCounter = 0
    var currentPopulation = p0 + pDelta + (percentage/100)
    var isTargetPopulationAccomplished = false

    if (currentPopulation < targetPopulation) { //we never reach our target population
      yearCounter = -2
      isTargetPopulationAccomplished = true
    } else if (currentPopulation == targetPopulation) {
      println("current city population is less than target population")
      yearCounter = -1
      isTargetPopulationAccomplished = true
    }
    while (!isTargetPopulationAccomplished && currentPopulation < targetPopulation) {
      currentPopulation *= p0 + pDelta + percentage/100
      yearCounter += 1
      println(s"after $yearCounter years the population will reach target population")
    }
  }


  println(getCityYear(1000, 2, 50, 1200)) // should print 3
  println(getCityYear(1000, 2, -50, 1200)) // should print -1
  println(getCityYear(1500000, 2.5, 10000, 2000000)) // should print 10
}
