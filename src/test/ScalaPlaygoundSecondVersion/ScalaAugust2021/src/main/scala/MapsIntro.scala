

object MapsIntro extends App {

  val myNumbers = (0 to 10).toArray
  println(myNumbers(3)) //indexed sequence, so we can look up values by their index
  println (myNumbers.mkString(","))

  //how would I go with storing my favourites
  //I would go by mapping
  //we create a collection of key -> value pairs,
  //mapping is pairing key and its values

  val myFavourites = Map(("food", "potatoes"), ("car", "vw"), ("colour", "pink"))
  println(myFavourites.mkString(","))
//maps require keys to be unique, but values can be delegated

  val anotherMap = Map("cats" -> 5, "dogs" -> 3)
  println(s"now I have ${anotherMap("cats")} cats ")


  //map of integers into string
  val numericMap = Map(180 -> "heroes", 300 -> "Spartans", 9000 -> "enough")
  println(numericMap(300))

  println(myFavourites.contains("food")) //a fast way to check if key names contain food

  for ((key,value) <- myFavourites) {
    println(s"My key: $key maps to -> $value")
  }

val greenMap = for ((key,value) <- myFavourites if (value == "green")) yield key
println(greenMap.mkString(","))

  val greenKey = (for ((key,value) <- myFavourites if (value == "green")) yield key )

// about getting values
  //what do we do if we're not sure?
  //we could use .contains --- or get option
  val foodValue = myFavourites.get("food")
  //OPTION STRING gives us an option
  //options are useful if we might get unusable answer (we get either something or nothing)
  val foodValueContent = foodValue.getOrElse("no food found :(")
  println(foodValueContent)

  val badKey = myFavourites.get("not a real key")
  val badKeyContents = badKey.getOrElse("sorry no such key")
  println(badKey)
  println(badKeyContents)

  //so we avoid exceptions that are not liked by Scala

val mySeq = Seq(("one", 10), ("two", 20), ("three", 30))
  val myMap = mySeq.toMap
  println(mySeq)
  println(myMap); for(((key,value), index) <- myMap.zipWithIndex) println(s"Item No.$index with $key -> $value")
        println(myMap.getOrElse("some non existent key", "no key found, sorry"))

  val myBiggerMap = myMap + ("four" -> 404)
  println(myBiggerMap)
  //we can print it out like this, without making a string

  val mergeMap = myMap ++ anotherMap
  println(mergeMap)

  var x = Map("AL" -> "Alabama")
  //add one element

  x += ("AK" -> "Alaska")
  println(mergeMap)

  //MUTABLE MAPS
  val muteMap = scala.collection.mutable.Map("cats" -> 5, "dogs" -> 3, "kids" -> 3)
  println(muteMap)
  muteMap("birds") = 452
 //so we can add keys to existing mutable maps
 println(muteMap)

 // I can create a map out of an array through yield
 //val squareMap = for (n <- myNumbers) yield n*n
  //or I could go other way
val squareMap = (for (n <- myNumbers) yield (s"Number $n squared", n*n)).toMap
  println(squareMap)

//we can also use maps to create maps
  val squareArray = myNumbers.map(n => (s"Number $n squared", n*n))
  val squareMapAgain = squareArray.toMap //we could have called toMap in the previous line, too
  println(squareArray.length)
  println(squareArray.mkString(","))
  //so what is the difference between Array of Tuples and Map of String -> Int??
  //Array you call by number index
  //map you call directly, by using key

  println(squareMapAgain.keys.mkString(",")) //getting an array of map keys
  println(squareMapAgain.getOrElse("number 3 squared", -1))

  val myKeys = squareMapAgain.keys.toArray
  val myValues = squareMapAgain.values.toArray

  println(muteMap)
  //removing elements from the map
  //remove key-value pairs by key only from the mutable map
  muteMap -= "cars"
  println(muteMap)
  muteMap("birds") += 987 //I am updating that pair by adding to its previous value
  println(muteMap)

  //I can remove or add multiples

  muteMap --= Seq ("birds", "dogs")
println(muteMap)


}
