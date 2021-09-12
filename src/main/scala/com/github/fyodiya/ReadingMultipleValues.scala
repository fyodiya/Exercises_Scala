package com.github.fyodiya
import scala.io.StdIn.readLine

object ReadingMultipleValues extends App {
  val userInput = readLine("Enter Your first name age and eye color separated by single space ")
  //we would usually use this with strange user input coming from elsewhere

  //the return is a tuple of 3 values
  def parseUserInput(userInput: String): (String, Int, String) = {
    //if we expect dirty input we can clean it up a bit first
    //https://alvinalexander.com/scala/how-to-convert-multiple-spaces-to-single-space-regex/

    val trimmedInput = userInput.replaceAll(" +", " ") //so we replace one or more whitespace with single
    //TODO do full regex match for name age as number and eye color as string
    trimmedInput match {
      case s"$name $age $eyeColor" => (name, age.toInt, eyeColor)
      case s"$name" => return (name, 0, "unknown") //there were no spaces
      case _ => return ("noName", 0, "unknown")
    }
    userInput match {
      case s"$name $age $eyeColor" => {
        println(name, age, eyeColor) // for debugging
        val ageFixed = if (age.length == 0) 0 else age.toInt
        (name, ageFixed, eyeColor) //this is our return
    }
    ("Valdis", 46, "brown") //FIXME
  }

  //I unpack the tuple immediately since I do not like using tuples
  val (name, age, eyeColor) = parseUserInput(userInput)
  println(s"Cool name $name, you are $age old and your eyes are $eyeColor")

  //alternative is more wordy
  val myTuple = parseUserInput(userInput)
  val nameToo = myTuple._1 //I prefer to avoid using tuples directly

}