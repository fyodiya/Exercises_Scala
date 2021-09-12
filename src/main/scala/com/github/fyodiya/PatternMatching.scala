package com.github.fyodiya

import _root_._
import com.github.fyodiya.Utilities.getMonth

object PatternMatching extends App {
 // i is an integer
 val i = 55

 //instead of writing a big if else chain this is preferable
 i match {
  case 1 => println("January") // I could call another function here as well instead of println
  case 2 => println("February")
  case 3 => println("March")
  case 4 => println("April")
  case 5 => println("May")
  case 6 => println("June")
  case 7 => println("July")
  case 8 => println("August")
  case 9 => println("September")
  case 10 => println("October")
  case 11 => println("November")
  case 12 => println("December")
  // catch the default with a variable so you can print it
  case whoa => println("Unexpected case: " + whoa.toString)
 }

 val month = i match {
  case 1 => "January"
  case 2 => "February"
  case 3 => "March"
  case 4 => "April"
  case 5 => "May"
  case 6 => "June"
  case 7 => "July"
  case 8 => "August"
  case 9 => "September"
  case 10 => "October"
  case 11 => "November"
  case 12 => "December"
  case _ => "Invalid month" // the default, catch-all
 }
 //without pattern matching we could have used an array with month values Array("January", "February") but we still would nee to check bounds

 println(s"The month we have is $month")

 println(getMonth(3))
 println(getMonth(0))
 println(getMonth(12))
 println(getMonth(13))
 println(getMonth(-1))

 //we can use pipe character | to separate similar cases
 val oddResults = i match {
  case 1 | 3 | 5 | 7 | 9 => "odd"
  case 2 | 4 | 6 | 8 | 10 => "even"
  case default => s"this number $default is not supported ... "
 }
 println(oddResults)

 val cmd = "stop or start"
 cmd match {
  case "start" | "go" => println("starting")
  case "stop" | "quit" | "exit" => println("stopping")
  case _ => println("doing nothing")
 }

 def echoWhatYouGaveMe(x: Any): String = x match {
  // constant patterns
  case 0 => "zero"
  case true => "true"
  case "hello" => "you said 'hello'"
  case Nil => "an empty List"
  // sequence patterns
  case List(0, _, _) => "a three-element list with 0 as the first element"
  case List(1, _*) => "a list beginning with 1, having any number of elements"
  case Array(1, _*) => "an array beginning with 1, having any number of elements"
  case Array(1.7, _*) => "an array starting with 1.7, any number of elements"
  case Vector(1, _*) => "a vector starting with 1, having any number of elements"
  // tuples
  case (a, b) => s"got $a and $b"
  case (a, b, c) => s"got $a, $b, and $c"
  // constructor patterns
  //    case Person(first, "Alexander") => s"found an Alexander, first name = $first"
  //    case Dog("Dzulbars") => "found a dog named Dzulbars"
  //FIXIT case Car("Ford","Black", "T") => "a black model T Ford"
        //we can match on some specific property of of our class
 //FIXIT  case Car("VW",color, model) => s"VW model: $model color: $color"
       // typed patterns
  case s: String => s"you gave me this string: $s"
  case i: Int => s"thanks for the int: $i"
  case f: Float => s"thanks for the float: $f"
  case a: Array[Int] => s"an array of int: ${a.mkString(",")}"
  case as: Array[String] => s"an array of strings: ${as.mkString(",")}"

  //    case d: Dog => s"dog: ${d.name}"
  case list: List[_] => s"thanks for the List: $list"
  case m: Map[_, _] => m.toString
  // the default wildcard pattern
  case default => s"Not found so default for ${default.toString}" //toString is available for pretty much everything
  //    case _ => "Unknown" //alternative when we do not want to show the input for default
 }
 println(echoWhatYouGaveMe(0))
 println(echoWhatYouGaveMe("hello"))
 println(echoWhatYouGaveMe("hello there!"))

 println(echoWhatYouGaveMe(List(0,1,7)))
 println(echoWhatYouGaveMe(List(0,1,7,10)))
 println(echoWhatYouGaveMe(List(1,0,3,5,1241431)))
 println(echoWhatYouGaveMe(Array(1,0,3,5,1241431)))
 println(echoWhatYouGaveMe(Array(0,0,3,5,1241431)))
 println(echoWhatYouGaveMe(Array("one","two")))
 println(echoWhatYouGaveMe(Array(1.7,2.7)))

 println(echoWhatYouGaveMe(Car()))
 println(echoWhatYouGaveMe(Car("VW")))
 println(echoWhatYouGaveMe(Car("VW", "yellow", "Touran")))
 println(echoWhatYouGaveMe(Car("Peugot"))) //this goes to default and gets pretty printed because Car is a case class

 println(echoWhatYouGaveMe(Map((1,"one"),(2,"two"))))

def stringMatcher(text:String): String = text match {
 case s"name: $myName" => s"Cool, your name is: $myName"
 case s"lastName:$myName" => s"Cool, your last name is: $myName"
 case s"$year - $time" => s"Ah, the year is $year and time is $time!"

 case _ => s"Unrecognized string"
}

 println(stringMatcher("name: Elina"))
 println(stringMatcher("lastName: Fjodorova"))
 println(stringMatcher("2021-21-20:PM"))

}