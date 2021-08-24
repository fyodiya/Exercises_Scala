object CollectionsIntro extends App {
  val u = 5
  val b = 15
  val c = 35
  //we want to store a lot of integers
  //we could do this:
  val a1 = 6
  val a2 = 7
  val a3 = 8
  //don't do this as much as  possible

  //using data collection is necessary to be good at coding
  val myArray = Array(1,2,3,4,10,12,32,18,52)
  //it's an array of integers

  println(myArray.head) //same as myArray(0)
  println(myArray(4))
  println(myArray.last)
  print(myArray.length-1) // same as last, because we start with  index -1
  println(myArray.sum)
  println(myArray.min)
  println(myArray.max)
  //println(myArray(9))  can't, because we start with index -1
  println(myArray(8))

  //calculation of an average
  val avg = myArray.sum / myArray.length
  println(s"$avg is an average form my array, but its an Integer")
  //val avgDouble: Double = 1.0 * myArray.sum / myArray.length //
  //i made it into Double
  val avgDouble = myArray.sum.toDouble / myArray.length
  println("I made into Double")

  for(element <- myArray) println(element)
  //we print all elements
  myArray.foreach(println) //even shorter method to print all elements

  //changing some values
  //by default collections are immutable, Scala prefers immutable over mutable
  //so how to create newarray out of an old one?
  val arr200 = for(number <- myArray) yield number * 200
  arr200.foreach(println)

  //YIELD creates a new element for a new collection out of an exisitng collection
  //it works together with FOR LOOP

  val myTexts = for (n <- myArray) yield s"Item in my collection is $n"
  //we transform data which we have into other form

  val moreTexts = for ((item, index) <- myArray.zipWithIndex) yield s"Number No. $index is $item"
  moreTexts.foreach(println)

  val numbers = (0 to 10).toArray
  numbers.foreach(println)

  val squares = for (n <- numbers) yield n*n
  //for each number we will create its square
  squares.foreach(println)

  //the old way of doing it is by using loops (mutable sequences), but it's very time cosnuming
  //it is discouraged

  val evenSquare = squares.filter(n => n % 2 == 0) //for filtering we need to enter what the conditions for each element needs to be true
  evenSquare.foreach(println)

  val evenSquaresToo = for (n <- squares if (n % 2 == 0)) yield n
  evenSquaresToo.foreach(println)
  //filtering with yield by putting it inside

  //adding text whether it's odd or even
  val myNumberDescriptions = for (n <- squares) yield {
    if (n % 2 == 0) s"even square $n"
    else s"odd square $n"
  }

  myNumberDescriptions.foreach(println)

  //alternative to YIELD, it's even shorter
  val cubes = numbers.map(n => n*n*n) //we create a mapping from one collection to another
  cubes.foreach(println)

  def getNumberDescription(n: Int): String = {
    if (n % 2 == 0) s"even square $n"
    else s"odd square $n"
  }
  val myNumberDescriptionsAgain = for (n <- cubes) yield getNumberDescription(n)// instead of writing out the ifs
   println

  val myCubesDescription = cubes.map(n => getNumberDescription(n))
  //shorter, but it does the same thing
  myCubesDescription.foreach(println)





}
