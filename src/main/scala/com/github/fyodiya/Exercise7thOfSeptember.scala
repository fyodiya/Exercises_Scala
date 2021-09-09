package com.github.fyodiya
import scala.io.StdIn.readLine

object Exercise7thOfSeptember extends App {
  //write a function that returns day of the week in English
  //given an index 1 to 7
  //if value is outside return Unknown Weekday

  def getDayOfWeek(d: Int): String = d match {
    case 1 => "Sunday"
    case 2 => "Monday"
    case 3 => "Tuesday"
    case 4 => "Wednesday"
    case 5 => "Thursday"
    case 6 => "Friday"
    case 7 => "Saturday"
    case _ => "Unknown" //
  }
//test
  for (d <- 0 to 8)
    println(getDayOfWeek(d))

  val dayOff = readLine ("What day of the week do you want to take off?").trim.toInt
  val dayWeek =  getDayOfWeek(dayOff)
  val dayOffs = dayWeek
  if (dayOff == 6 || dayOff == 7) { // note usage of || instead of &&
    println("No, it is already a holiday")
  } else if (dayOff %2 == 0) {
    println ("No, Tuesdays and Thursdays we have an important tasks")
  } else {
    println("Okay, you can have this day off :)")
  }


}
