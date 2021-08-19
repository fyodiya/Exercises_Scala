object Functions extends App {

  println("Let's eat!")
  println("eating potatoes.")
  println("eating potatoes.")
  println("eating potatoes.")

  for (_ <- 0 until 5) println("Eating potatoes again and again.")

  println("Sitting at the table.")
  println("Picking up fork.")
  println("Eating potatoes.")
//one task is repeated multiple times, by the tasks are fone one by one altogether

  for (_ <- 1 to 3)({
    println("Sitting at the table.")
    println("Picking up fork.")
    println("Eating potatoes.")
  })


  def eat() = {
    println("Sitting at the table.")
    println("Picking up fork.")
    println("Eating potatoes.")
  }
  for (_ <- 0 until 3) eat()

//we have defined EAT
//we see a structure now, structure of that action or process





}
