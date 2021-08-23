object Population extends App {
  //write a function cityPop which takes the following 4 parameters
  //p0: Int how many people are in the beginning
  //percentage: Int - yearly growth rate in %
  //delta: Int - how many people emigrate/immigrate each year
  //targetPopulation: Int population we want to reach

    println("Function to calculate city growth")
    def getCityYear(p0: Int, pDelta: Int, targetPopulation: Int): Unit = {
      val finalPopulation: Int = p0 + (targetPopulation / pDelta)
        if (finalPopulation <= 0) if (finalPopulation < 0)
          println("The city will NEVER reach target population") else {
          println(s"the target population will be reached in the year $finalPopulation")
        } else {
          do {
            if (finalPopulation <= 0) {
              if (finalPopulation < 0)
                println("The city will NEVER reach target population")
            } else println(s"the target population will be reached in the year $finalPopulation")
          } while (finalPopulation > targetPopulation)
        }
      }

      println(getCityYear(1000, 50, 1200)) // should print 3
      println(getCityYear(1000, -50, 1200)) // should print -1
      println(getCityYear(1500000, 10000, 2000000)) // should print 10

    //we want to return the year city will reach targetPopulation
    //or we return -1 if the city will NEVER reach the population
    //it is a little bit tricky because we do not want to use return statements
    //we want to return the last line only
    //so you probably want to use some variable to hold the result

    //you will need a loop - while probably
    //you will need some if else statements

    //def getCityYear(p0: Int, percentage: Double, delta: Int, targetPopulation: Int):Int
}