object StringLooping extends App {

    def processString(text:String, uppercaseChars:String =""):String = {
      //TODO replace All characters in uppercaseChars with their uppercase versions
      //one approach could be to have a variable which we keep changing each time for replacement with uppercase
      var resultText = text
      for (char <- uppercaseChars) {
        //TODO we want to replace each character by character inside the loop
        println(s"Working on making $char uppercase to ${char.toUpper}")
        resultText = resultText.replace("","") //FIXME
        //we can not replace text inside string but we can create a new string out of old string
        //you want to replace each of the characters with their uppercase version
        //so the idea is to use replace on result Text...

        //resultText = resultText.replace("altijas", "ALTIJAS")
        //too specific, we should make it more general

        println(s"current result is $resultText")


        println(processString("Got meal porridge", "ae"))
        val food = "Oat meal porridge"
        println(food)
        println(food.replace("a", "A"))
        println(food.replace("e", "E"))




      }


      resultText //FIXME for now we return original text
    }

    println(processString("Valdis")) //here function works correctly already as a base/default case
    println(processString("Valdis", "ad")) //so we want to see "VAlDis"
    println(processString(text="Baltijas Ceļš", uppercaseChars = "altijas")) //we want to see "BALTIJAS Ceļš"

    println("Valdis".replace("d", "D"))


}
