package com.github.fyodiya

object UsingUtilities extends App {
  println(Utilities6thOfSept.MYP)

  import _root_.Car
  val newCar = new Car
  //if I have something in teh root to import and use here
  println(newCar)



}
