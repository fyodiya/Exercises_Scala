object StringMethods extends App{

  println("Testing some string functionality")

  val food = "kartupelis" //potato in Latvian
  println(food.substring(5))
  println(food.substring(2, 7)) //what will it print remember about 0 based indexing in programming

  val numbers = "0123456789" //just a string not a number
  println(numbers.substring(2, 6)) //it should print 2345

  println(food(0)) //k (1st character with index 0
  println(food(1)) //a (2nd character with index 1

  println(food(9)) //s
  //well what do we do if we have a long string and we do not know the actual length off hand?

  println(food.length)
  //so to print last character of string we cold do this
  println(food(food.length-1)) //-1 because we start at 0

  println(food.head) //first character
  println(food.tail) //that is everything BUT first character

  //there was also everything but last character
  println(food.last) //prints last character

  val firstChar = food.head
  val firstCharAlso = food(0)

  //so above values are characters, this means that we can print their ASCII/Unicode values

  println(s"$firstChar has an ASCII code of ${firstChar.toInt}")

  println(food.toUpperCase())
  val msg = "artificial intelligence INDEED ?"
  println(msg)
  println(msg.capitalize) //so only the first letter is uppercase, if it is already uppercase nothing happens

  //so how would be get rid of uppercase but capitalize the first character?
  println(msg.toLowerCase.capitalize) //Artificial intelligence indeed ?

  println(food.startsWith("kart"))
  println(food.endsWith("elis"))
  println(food.contains("art"))
  println(food.contains("food")) //well that will be false because this particular food item is in Latvian :)

  println(food.replace("a", "A"))
  println(food.replace("art", "food")) //silly I know

  val magic = "abracadabra"
  println(magic.replace("a", "u"))
  println(magic.replace("abra", "oho"))

  //remember that strings in general ar unchangable so if we want to save the results of our changes we need new values/variables

  val newMagic = magic.replace("ab", "AB")
  println(newMagic)

  val dirtyString = " Riga is a port city    "
  println(dirtyString)
  println(dirtyString.trim) //so any whitespace characters are trimmed away
  println(dirtyString.trim.toUpperCase.tail) //we can keep chaining

}
