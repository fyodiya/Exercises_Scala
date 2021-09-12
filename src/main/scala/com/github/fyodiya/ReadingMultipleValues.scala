package com.github.fyodiya
import scala.io.StdIn.readLine

object ReadingMultipleValues extends App {
  val userInput = readLine("Enter Your first name age and eye color separated by single space ")
  //we would usually use this with strange user input coming from elsewhere

  //we return a tuple of 3 values
  def parseUserInput(userInput: String): (String, Int, String) = {
    //if we expect dirty input we can clean it up a bit first
    //https://alvinalexander.com/scala/how-to-convert-multiple-spaces-to-single-space-regex/
    val trimmedInput = userInput.replaceAll(" +", " ") //so we replace one or more whitespace with single
    //TODO do full regex match for name ageasnumber and eyecolor as string
    trimmedInput match {
      case s"$name $age $eyeColor" => (name, age.toInt, eyeColor)
      case s"$name" => (name, 0, "unknown") //there were no spaces
      case _ => ("noName", 0, "unknown")
    }
    //    ("Valdis", 46, "brown") //FIXME
  }

  //I unpack the tuple immediately since I do not like using tuples
  val (name, age, eyeColor) = parseUserInput(userInput)
  println(s"Cool name $name, you are $age old and your eyes are $eyeColor")

  //alternative is more wordy
  val myTuple = parseUserInput(userInput)
  val nameToo = myTuple._1 //i prefer to avoid using tuples directly
  //etc
}