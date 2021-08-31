object ExerciseAug31st extends App {
  //TODO write a function isPangram which tests whether string is a pangram
  //https://en.wikipedia.org/wiki/Pangram
  //text can contain extra characters that is fine such as !., etc

  val alphabetArray = ('a' to 'z').toArray //we can create sequences out of characters not only numbers
  println(alphabetArray.mkString(""))
  val alphabet = alphabetArray.mkString("")

  def isPangram(text:String, alpha:String="abcdefghijklmnopqrstuvwxyz"):Boolean = {
    //TODO bonus if you can make it work with any alphabet it shouldnot take any extra work
    val textSet = text.toLowerCase.toSet //we do not care about capitals in this case
    val alphaSet = alpha.toSet
    alphaSet.subsetOf(textSet) //so we are checking whether alphabet set is subset or equal set to textSet which could be larger with extra symbols
  }

  println(isPangram("some text")) //should be false
  println(isPangram("The quick brown fox jumps over the lazy dog")) //should be true
  println(isPangram("The five boxing wizards jump quickly.")) //should be true

  def getCommonElements(s1: Seq[Int], s2: Seq[Int], s3: Seq[Int]): Seq[Int] = {
    //TODO return sorted Sequence of common elements in all 3 sequences
    s1.toSet.intersect(s2.toSet).intersect(s3.toSet).toSeq.sorted
    //same as above
    (s1.toSet & s2.toSet & s3.toSet).toSeq.sorted
  }

  val seq1 = Seq(5, 1, 2, 3, 4, 8, 7)
  val seq2 = Vector(5, 6, 7, 3, 4, 8, 7, 33)
  val seq3 = Array(5, 0, 8, 3, 1,7, -55)

  println(getCommonElements(seq1, seq2, seq3))
}
