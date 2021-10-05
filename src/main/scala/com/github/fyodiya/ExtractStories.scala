package com.github.fyodiya

object ExtractStories extends App {
  object ExerciseSep14ExtractStories extends App {
    val destDir = "src/resources/"
    val srcPath = "src/resources/61262-0.txt"
    val lines = Utilities.getLinesFromFile(srcPath)
    println(s"There are ${lines.length} lines in $srcPath")

    //SOLVED get some stats about the file
    //SOLVED get character count across all lines - so how many symbols are in the file total
    val charCount = Utilities.getCharacterCount(lines)
    val charCountWithoutNewlines = Utilities.getCharacterCount(lines, newline = "")

    //  val lineLengths = lines.map(_.length) //so for each line we get its length and store into an Array
    //  val charCount = lineLengths.sum
    //  val bigText = lines.mkString //so we put all lines next to each other into one big string
    //  val charCountToo = bigText.length
    println(s"There are $charCount characters in the book counting newline symbols")
    println(s"There are $charCountWithoutNewlines characters in the book without newline symbols")

    val wordCounts = Utilities.getWordCountPerLine(lines)
    val wordCountTotal = wordCounts.sum
    println(s"There are $wordCountTotal words/tokens in our book")


    val matchText = "CONTENTS"
    val linesNumberWithMatch = lines.zipWithIndex.filter(lineTuple => lineTuple._1.contains(matchText))
    println(linesNumberWithMatch.head)
    val startingIndex = linesNumberWithMatch.head._2 //a bit ugly but it works
    //so now we know where to slice
    val tocLines = lines.slice(startingIndex + 1, startingIndex + 25) //for now we are using magic number 20 we could also find the ending

    println(tocLines.mkString("\n"))

    //  we will split by one or more (+) whitespaces
    //  val wordsInLines = lines.map(_.split(" +")) //so for each line we create an array of Strings (words)
    //  wordsInLines.slice(0,25).foreach(arr => println(arr.mkString(":::")))
    //  val wordCountPerLine = wordsInLines.map(_.length)
    //  wordCountPerLine.slice(0,25).foreach(println)
    //  println("*"*40) //just some divider for visuals
    //  val wordCountAlso = Utilities.getWordCountPerLine(lines)
    //  wordCountAlso.slice(0,25).foreach(println)

    //TODO filter and convert tocLines into story names only (without Roman numerals)
    //idea is notice that Roman numerals are all first and they have no spaces
    //so we want all text that is not first word
    val storyNames = for (line <- tocLines if line.nonEmpty) yield {
      //TODO do some more work here in preparing the line
      //idea trim each line then get everything but first word(which is Roman numeral in this case)
      val words = line.trim.split(" +")
      //so tail will give me array or other sequence with everything BUT first item, we could have use slice also but then we'd need length
      val title = words.tail.mkString(" ") // only catch is that we lost any extra whitespace between words
      title
    } //this should filter empty lines
    println("*" * 40) //just some divider for visuals
    storyNames.foreach(println) //so we do have all the stories we just want to get rid of Roman numerals

    //now that we have our story names, we can go look for the stories
    //this will be a bit more difficult because we need to figure out where the story ends

    //  val firstStoryTitle = storyNames.head

    //FIXME improvement use find or
    //TODO https://www.baeldung.com/scala/find-index-element-in-list
    def findLineNumber(lines: Array[String], toMatch: String): Int = {
      //so this not Scala style using early return but very convenient here
      for ((line, index) <- lines.zipWithIndex) {
        if (line.trim == toMatch) {
          println(s"Found Story: $toMatch at line ${index + 1}") //zipIndex starts with 0 but text file starts at 1
          return index + 1 //Scala does not like early return but here it is too convenient to avoid
        }
      }
      0 //nothing found
    }

    //nicer way of doing the above
    def findLineNumberAlso(lines: Array[String], toMatch: String, remove: String = "the"): Int = {
      //    val cleanMatch = toMatch.replace("_","")
      //we can make an internal helper function for this only available for findLineNumberAlso
      def trimFun(line: String, remove: String, replacement: String = ""): String = line.
        trim.
        toLowerCase.
        replace(remove, replacement).
        replace(" ", "") //so we get rid of the white space
      //it is possible we can find some false positive since we are going to lower case and removing the by default

      val cleanMatch = trimFun(toMatch, remove)
      println(s"CleanMatch is $cleanMatch")
      //    lines.indexWhere(line => trimFun(line, remove).contains(cleanMatch)) + 1 //+1 because our line numbers start with 1, if not found -1 will be 0
      lines.indexWhere(line => trimFun(line, remove) == cleanMatch) + 1 //+1 because our line numbers start with 1, if not found -1 will be 0
    }

    val storyStarts = storyNames.map(story => findLineNumber(lines, story))
    println(storyStarts.mkString(","))
    val storyStartsAlso = storyNames.map(story => {
      println(s"Finding story: $story")
      //    findLineNumberAlso(lines.slice(100,lines.length), story)
      findLineNumberAlso(lines, story)
    })
    println(storyStartsAlso.mkString(","))

    val startIndex = storyStartsAlso
    val endIndex = storyStartsAlso.tail ++ Array(lines.length) //so we do not need start of the story but we need the last line
    println(startIndex.mkString(","))
    println(endIndex.mkString(","))
    //-1 will give us the title since we added the number , so +1 was only for finding lines in the text but our
    //lines already are 0 based index
    //-5 is kind of iffy but we do not want the end
    val myStories = for ((start, end) <- startIndex zip endIndex) yield lines.slice(start - 1, end - 5).mkString("\n")

    //so i will go through all airs of stories and their names and save them
    //we might need a sanitize function since some names have some extra characters
    for ((story, storyTitle) <- myStories zip storyNames) Utilities.saveText(destDir + storyTitle + ".txt", story)

    //https://alvinalexander.com/scala/how-find-regex-patterns-matches-in-strings-scala/
   // val numPattern = "[0-9]+".r //this is very loose
    val numPattern = "^.*[0-9].*$".r //this one is much stricter

    val numLines = lines.filter(line => numPattern.findFirstIn(line).isDefined)
    println(numLines.length)
    numLines.foreach(println)

    val text = lines.mkString("\n")
    val phonePattern = "(\\d\\d\\d) \\d\\d\\d-\\d\\d\\d\\d".r
    println(phonePattern.findFirstIn(text).getOrElse("Not found"))

    //val zipCodePattern = "\\w\\w \\d\\d\\d\\d\\d".r
    val zipCodePattern = "[A-Z] [A-Z] \\w\\w \\d\\d\\d\\d\\d".r //much stricter
val zipCodes = zipCodePattern.findFirstIn(text).getOrElse("Not found")

    val linesWithZipCodes = lines.filter(line => zipCodePattern.findFirstIn(line).isDefined)
    linesWithZipCodes.foreach(println)

    //homework - begin with filtering
    //slicing should be the last option

  }
}