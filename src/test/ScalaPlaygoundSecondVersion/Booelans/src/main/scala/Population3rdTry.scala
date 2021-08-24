object Population3rdTry extends App {
  def nextYear (p0: Int, pDelta: Int, percentage: Double, targetPopulation: Int) = targetPopulation - (p0 + pDelta + percentage/100)

  def getCityYear(p0: Int, pDelta: Int, percentage: Double, targetPopulation: Int) = {
    var yearCounter = 0
    var currentPopulation = nextYear(p0: Int, pDelta: Int, percentage: Double, targetPopulation: Int)
    var isTargetPopulationAccomplished = false

    if (currentPopulation < targetPopulation) {
      yearCounter = -2
      isTargetPopulationAccomplished = true
    }
    else if (currentPopulation == targetPopulation) {
      yearCounter = -1
      isTargetPopulationAccomplished = true
    }
     while (!isTargetPopulationAccomplished && currentPopulation < targetPopulation) {
       currentPopulation = nextYear(p0: Int, pDelta: Int, percentage: Double, targetPopulation: Int)
       yearCounter += 1
       println(s"After $yearCounter years the city population will reach target population")
     }

  }

  println(getCityYear(1000, 2, 50, 1200)) // should print 3
  println(getCityYear(1000, 2, -50, 1200)) // should print -1
  println(getCityYear(1500000, 2.5, 10000, 2000000)) // should print 10
}
