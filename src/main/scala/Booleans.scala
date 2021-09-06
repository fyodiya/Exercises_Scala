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
  println(3 != 3) //also false

  //we can use ! to toggle true to false and vice versa
  //it's an old programming trick
  var myToggle = true
  print(myToggle)
  myToggle = ! myToggle
  println(myToggle)
  //we can reverse it by using the same logic
  // we can toggle only booleans, not inetegers or strings

  //we can combine logic statements
  println(true && true)
  println(true && true && 5 == 5)
  println(true && false)
  //one bad apple ruins everything
  println(true && true && true && false) // it's still gonna be false

  println(10 > 7 && "Val" != "Vol")

  println(true || true)
  println(true || false)
  println(false || true)
  println(false || false) //only this will be false, others are true

  println(false || false || false || false || true || false) //one true statement makes OR true
  //we usually try to use 2-3 || or && at once

  //it's hard to remember which || or && is more important
  //so we use parenthesis
  println((true || false) && (false || true))
  //usually the order doesn't matter, but there are few exceptions

  // conditionals, because we need to branch in order to perform operations














}
