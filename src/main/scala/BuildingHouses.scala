import com.github.fyodiya.Utilities

object BuildingHouses extends App {
  //we create a homersHouse object out of House class blueprint
  val homersHouse = new House("Homer's house", "central", true)
  println(homersHouse)
  println(homersHouse.heating)
  println(homersHouse.hasGarage)
  println(homersHouse.realHouseName)
  //same blueprint but different object
  val flandersHouse = new House("Flanders", "coals", true)
  println(flandersHouse.heating)
  println(flandersHouse.age)
  homersHouse.prettyPrint()
  flandersHouse.prettyPrint()
  homersHouse.printSecrets()
  val myResult = homersHouse.myAdd(5, 33)
  println(myResult) //point being that I do not need to print it if I do not need it
  val alsoResult = flandersHouse.myAdd(10,55) //in this case we have two instances of myAdd that do the same thing
  println(alsoResult)
  val thirdResult = Utilities.add(5,10) //Utilities is a singleton object, meaning we only have one
  println(thirdResult)
  homersHouse.increaseHouseAge(17)
  println(homersHouse.age)
  println(flandersHouse.age) //different now

  homersHouse.changeSecret("Bart")
  homersHouse.printSecrets()
  flandersHouse.printSecrets() //should have old secrets

  //I created a whole collection of House instances
  val myVillage = for (n <- 0 to 20) yield new House(s"House No. $n", "solar", true )

  myVillage(3).prettyPrint() //this is actually 4th in our village we starte with 0 :)

}
