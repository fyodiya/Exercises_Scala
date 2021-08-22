object Functions extends App {

  println("Let's eat")
  println("eating potatoes")
  println("eating potatoes")
  println("eating potatoes")

  for (_ <- 0 until 5) println("Eating potatoes again and again")

  println("Sitting down at the table")
  println("Picking up the fork")
  println("Eating potatoes")
  //if we repeat one task multiple tasks or if multiple tasks go one after another
  for (_ <- 1 to 3) {
    println("Sitting down at the table")
    println("Picking up the fork")
    println("Eating potatoes")
  }

  def eat () = {
    println("Sitting down at the table")
    println("Picking up the fork")
    println("Eating potatoes")
  }

//so we can now abstract our act of eating into a single function (also called METHOD)
  for (_ <- 0 until 3) eat
  println ("Really full now after all that eating")
  println("Resting, getting hungry again")
  eat()











}
