import WhileLoops.counter

object Population extends App {
  //write a function cityPop which takes the following 4 parameters
  //p0: Int how many people are in the beginning
  //percentage: Int - yearly growth rate in %
  //delta: Int - how many people emigrate/immigrate each year
  //targetPopulation: Int population we want to reach

  println("function to calculate city growth")
  def getCityYear (p0: Int, growthPercentage: Int, pDelta: Int, targetPopulation: Int) = {
    val result()
  }


  //we want to return the year city will reach targetPopulation
  //or we return -1 if the city will NEVER reach the population
  //it is a little bit tricky because we do not want to use return statements
  //we want to return the last line only
  //so you probably want to use some variable to hold the result
  while(counter < 0){

  }
  //you will need a loop - while probably
  //you will need some if else statements
  //if we write comments /**
  //those are so called ScalaDoc style comments and they can be used by automatic tools to create documentation

  // */

  /**
   * getCityYear
   * @param p0 - original City population
   * @param percentage - yearly growth rate in percentages
   * @param delta - how many people immigrate(+)/emigrate to the city each year
   * @param targetPopulation - population we want to reach
   * @return number of years to reach , -1 if not reachable
   */
  def getCityYear(p0: Int, percentage: Double, delta: Int, targetPopulation: Int):Int = {
    9000 //FIXME
  }

  println(getCityYear(1000,2,50,1200)) // should print 3
  println(getCityYear(1000,2,-50,1200)) // should print -1
  println(getCityYear(1500000,2.5,10000,2000000)) // should print 10




}