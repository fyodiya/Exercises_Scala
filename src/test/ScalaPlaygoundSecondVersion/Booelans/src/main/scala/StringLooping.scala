object StringLooping extends App {

  val myName = "Valdis"
  println(myName(0)) //indexing starts with 0, not 1
  println(myName(5))

  for (c <- myName) println(s"current character is $c")

  for (index <- 0 until myName.length) println(s"Char. no $index is ${myName(index)}")
for ((index, myChar) <- myName.zipWithIndex) println(s"Index $index and char is $myChar")

  //  def processString(text:String, uppercaseChars:String =""):String = {
  //TODO replace All characters in uppercaseChars with their uppercase versions
  //one approach could be to have a variable which we keep changing each time for replacement with uppercase
  var resultText = text
  for (char <- uppercaseChars) {
    //you want to replace each of the characters with their uppercase version
    //so the idea is to use replace on result Text...
  }

  resultText //FIXME for now we return original text

}
