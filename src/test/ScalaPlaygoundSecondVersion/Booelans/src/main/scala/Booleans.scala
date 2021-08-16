object Booleans extends App {
  val isRaining = false // not "false", that'd be string
val isCold = true
  val a = 2
  val b = 3
  val c = 3.14
  val result = 4

  val aBiggerThanB = a > b

  val equalNames = "Valdis" == "valdis"
  print(equalNames)

  println(5 >= 4)
  print(5 >= 5)
  println(2 <= 1) //should be false

  println(5 < 6)
  println(10 == 10)
  println(100 > 99)

  println("Valdis" > "Voldemars") //we can compare strings
  println("Vald" > "Vold")

  print("V" > "A")
  print('V' > 'A') //we can compare single characters as well

  print("VAA" > "AZZZZZ") //first string will win because the first character wins

  //inequality
  print(5 != 10) //true statement
  println("Valdis" != "Voldis")

  println(2*2 != 4) //result will be false, because 2*2=4







}
