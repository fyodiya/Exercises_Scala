object Population3rdTry extends App {
//  def nextYear (p0: Int, pDelta: Double, percentage: Double, targetPopulation: Int) = currentPopulation  (p0 + pDelta + (p0*percentage/100))
println("function to calculate the growth of city population")
  def getCityYear(p0: Int, pDelta: Double, percentage: Double, targetPopulation: Int): Int = {
    var yearCounter = 0
    var currentPopulation = p0
//    var currentPopulation = nextYear(p0: Int, pDelta: Double, percentage: Double, targetPopulation: Int)
    var isTargetPopulationAccomplished = false
    var difference = targetPopulation - currentPopulation

     while (!isTargetPopulationAccomplished){// } && currentPopulation <= targetPopulation) {
//       currentPopulation = nextYear(p0: Int, pDelta: Double, percentage: Double, targetPopulation: Int)
       currentPopulation = (currentPopulation + pDelta + p0*percentage/100).toInt
println (s"$currentPopulation")
         yearCounter += 1
       if ((targetPopulation - currentPopulation)>difference) {
//         yearCounter = -2
         isTargetPopulationAccomplished = true
         println("the city will never reach its target population!")
       }
       else if (currentPopulation >= targetPopulation) {
//         yearCounter = -1
         isTargetPopulationAccomplished = true
         println(s"After $yearCounter years the city population will reach target population")
       }
     }
yearCounter
  }
  println(getCityYear(1000,50, 2, 1200)) // should print 3
  println(getCityYear(1000, -50, 2, 1200)) // should print -1
  println(getCityYear(1500000, 10000, 2.5, 2000000)) // should print 10

}
