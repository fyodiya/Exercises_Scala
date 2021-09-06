object SetExamples extends App {

  println("The Scala Set class is an iterable collection with no duplicate elements.")

  val mySet = Set (0,1,2,3,4,5,6,7,8,9,7,7,5,10)
  println(mySet)
  val myUniqueNumberArray = mySet.toArray.sorted
  println(myUniqueNumberArray.mkString(","))

  //so if you make an array of duplicates you can cast it to set than back to an array
  //and the duplicates will be gone

  val a = Array(8,5,7,3,5,8,7)
  val s = a.toSet
  val uniqueArray = s.toArray
  print(a.mkString(","))
  println(s.mkString(","))
  println(uniqueArray.mkString(","))

  val set = scala.collection.mutable.Set[Int]()
  println(set)
  set += 1
  println(set)
  set += 2 += 3
  println(set)
  set ++= Vector(4, 5)
  println(set)
  set ++= Array(4,3,7,9,2) //here only not added before numbers will be added
  println(set)
  set ++= Array(-6,-4,-3,100,90,95,1)
  println(set)

  val is_6_added = set.add(6)
  val is_7_added = set.add(7)
  println(is_6_added, is_7_added)
  println(set)

  println(s"my set is ${set.size} long")

  set  -= 3
  println(set)
  set --= Array(2,6,6)
  println(set)
  //erasing some numbers form our set

  set.clear()
  println(set)

  //we can also get booleans on our removal out of set by using set.remove
  val is_6_removed = set.remove(6)
  print(is_6_removed)
  //it will be false

  val n1to5 = (1 to 5).toSet
  val n3to7 = (3 to 7).toSet
  println(n1to5)
  println(n3to7)
   val n3to5 = n1to5 intersect n3to7
  val n3to5also = n1to5 & n3to7 //same as above mentioned
  println(n3to5)
  println(n3to5also)

  //we can also perform UNION
  //we get all unique values across our sets

  val n1to7 = n1to5 union n3to7
  val n1to7also = n1to5 | n3to7
  println(n1to7)
  print(n1to7also)

  //unsymmetrical difference
  //we want everything that is on the left and is unique
  val n1to2 = n1to5 diff n3to7
  val n6to7 = n3to7 diff n1to5
  println(n1to2)
  println(n6to7)

  //we can iterate over sets by using for-loops
  //the order of items is undefined
  for (n <- n1to7) println(n)

  //sets are faster than sequences
  println(n1to7 contains 3)
  println(n1to7 contains 53)

  val numberToCheck = 568
  val contains_79 = n1to7 contains 79
  print(s"set ${n1to7} contains $numberToCheck: ${contains_79}")

  val myName = "Valdis"
  val myDrink = "Alus"
  val myLetters = myName.toSet
  val drinkLetters = myDrink.toSet

  println(myLetters, drinkLetters)
  val commonLetters = myLetters  intersect drinkLetters
  println(commonLetters)

  val commonLowerCase = (myName.toLowerCase.toSet intersect myDrink.toLowerCase.toSet)
  println(commonLowerCase)

  val text = "See, Spot Run. Spot! Run."
  val words = text.split("[ !,.]+")
  println(words.mkString)

  val wordSet = scala.collection.mutable.Set.empty[String]

  for (word <- words) wordSet += word.toLowerCase
  println(wordSet)





}
