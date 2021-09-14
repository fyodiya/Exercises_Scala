package com.github.fyodiya

import java.io.{File, FileWriter}
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

  /**
   *
   * @param dstPath - save Path
   * @param text - string to save
   */
  def saveText(dstPath: String, text: String, append:Boolean=false, verbose:Boolean=false):Unit = {
    //    import java.io.{PrintWriter, File} //explicit import
    if (verbose) println(s"Saving ${text.length} characters to $dstPath")
    val fw = new FileWriter(dstPath, append)
    //    val pw = new PrintWriter(new File(dstPath))
    if (append) fw.write("\n") //TODO think about appending custom header
    fw.write(text)
    fw.close() //when writing it is especially important to close as early as possible
  }

  /**
   *
   * @param dstPath - save Path
   * @param lines - array of Strings to save
   *              overwrites old file by default
   */
  def saveLines(dstPath: String, lines: Array[String], append:Boolean=false, lineEnd:String="\n"):Unit = {
    saveText(dstPath, lines.mkString(lineEnd), append)
  }

  /**
   * adapted from https://alvinalexander.com/scala/how-to-list-files-in-directory-filter-names-scala/
   * @param dir -- path to list files in
   * @param regex  - match to filter by, default is everything
   * @return -- returns a list of Files
   */
  def getListOfFiles(dir: String, regex:String=".*"):List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      //      d.listFiles.filter(_.isFile).toList
      d.listFiles.filter(file => file.isFile && file.getName.matches(regex)).toList
    } else {
      List[File]() //so we return empty list if nothing is found
    }
  }

  /**
   *
   * @param url - web resource locator
   * @return - we return the whole web page as string, it could be a text file
   */
  def getTextFromWeb(url: String):String = {
    val html = Source.fromURL(url) //does not have to html, just keep in mind this accessed external web address
    //BufferedSource means it is waiting to be processed because downloading from web might not be instant
    html.mkString
  }

  def getCharacterCount(lines: Array[String], newline:String="\n"):Int = lines.mkString(newline).length

  /**
   *
   * @param lines - our input text lines
   * @param sep - how to split words
   * @param removeEmptyLines - whether to remove empty lines
   * @return - array of word count per line
   */
  def getWordCountPerLine(lines: Array[String], sep:String=" +", removeEmptyLines:Boolean=true):Array[Int] = {
    //first we clean the lines if necessary
    val cleanLines = if (removeEmptyLines) lines.filter(_.trim.length > 0) else lines
    val wordsLines = cleanLines.map(_.split(sep))
    val wordCountPerLine = wordsLines.map(_.length)
    wordCountPerLine
  }

}