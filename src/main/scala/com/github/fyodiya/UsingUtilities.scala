package com.github.fyodiya

import _root_.Car //so if i have something at the root of the project that I need to import I can use this _root_

object UsingUtilities extends App {
  println(Utilities6thOfSept.MYP) //so I can other objects, classes etc from the same package

  val newCar = Car("Bugatti") //i had to import Car from _root_.Car because it is in the root of the project without package

  println(newCar)

}
