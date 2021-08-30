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




}
