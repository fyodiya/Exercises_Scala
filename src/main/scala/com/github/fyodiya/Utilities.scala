package com.github.fyodiya

import com.github.fyodiya.ReadingFiles.text

import scala.io.Source

/**
 * Utilities collects our commonly uses utilities across the whole project
 */
object Utilities {
  val MYP = 3.1415926
  def add(a:Int, b:Int): Int = a+b //functions that are to be used by others should have full type information
  //if we forget Intellij will remind us at some point

  /**
   *
   * @param monthIndex starting 1 to 12 included
   * @return month of the year as string
   *         note: valid months are 1 to 12
   */
  def getMonth(monthIndex: Int):String = {
    monthIndex match {
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
      //this leaves space to add extra month, really easy to add extra capabilities
      case _ => "Invalid month" // the default, catch-all
    } //as this is pattern matcher is the last item in our function the result gets returned
  }

  /**
   *
   * @param srcPath - relative path
   * @return array of Strings
   *         reads text file given a relative path
   */
  def getLinesFromFile(srcPath: String): Array[String] = {
    val bufferedSource = Source.fromFile(srcPath) //we have a source stream it could be network stream but here it is file stream
    val lines = bufferedSource.getLines().toArray //so we transfer this stream until it ends into lines
    //lines we define the ending character newline or \n
    bufferedSource.close //very important to close a file after reading, do not leave it hanging!
    lines
  }
}
