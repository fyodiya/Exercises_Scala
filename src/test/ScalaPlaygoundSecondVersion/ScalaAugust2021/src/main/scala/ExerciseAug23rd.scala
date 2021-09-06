object ExerciseAug23rd extends App {
def processString (text:String, upperCaseChars:String = ""): Unit = {
  //TODO replace all characters in the upper case with their upper case versions
  //one approach could be to have a variable which we keep changing each time for replacement with upper case
  var resultText = text
  for (char <- upperCaseChars) {
    //we want to replace each of characters with their uppercase version

  }
//hint - function "replace"
  resultText //FIXME for now it returns original text
}
  println(processString("Valdis")) //here function works correctly
println(processString("Valdis", "ad")) //we want to see "VALDis"

  println("Valdis".replace("d","D"))


}
