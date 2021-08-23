object Population extends App {
  //write a function cityPop which takes the following 4 parameters
  //p0: Int how many people are in the beginning
  //percentage: Int - yearly growth rate in %
  //delta: Int - how many people emigrate/immigrate each year
  //targetPopulation: Int population we want to reach

    println("Function to calculate city growth")
    def getCityYear(p0: Int, percentage: Double, pDelta: Int, targetPopulation: Int): Unit = {

      var finalPopulation: Double = {
        (p0 + pDelta + p0 * percentage / 100)
      }.toInt
      val years : Unit= {(targetPopulation - finalPopulation) / (pDelta + percentage/100)
        if (finalPopulation >= targetPopulation) {
          var resultYears = years
          println(s"the target population will be reached in $resultYears years")}
        else {
          println("target population hasn't been reached yet")
          val resultYears: Unit = (finalPopulation = targetPopulation + 1)
          println(s"the target population will be reached in $resultYears years")
        }
        else
        }



            println("The city will NEVER reach target population")
      }
  println(getCityYear(1000,2,50,1200)) // should print 3
  println(getCityYear(1000,2,-50,1200)) // should print -1
  println(getCityYear(1500000, 2.5,10000,2000000)) // should print 10

    //we want to return the year city will reach targetPopulation
    //or we return -1 if the city will NEVER reach the population
    //it is a little bit tricky because we do not want to use return statements
    //we want to return the last line only
    //so you probably want to use some variable to hold the result

    //you will need a loop - while probably
    //you will need some if else statements

    //def getCityYear(p0: Int, percentage: Double, delta: Int, targetPopulation: Int):Int
}