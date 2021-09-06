import scala.util.Random.nextInt

object SeqSpeedTest extends App {
  println("Let's test various Scala sequence type data structures")
  val endNum = 100_000;
  val arr = (0 to endNum).toArray //arrays are continuous chunks of memory in your computer or elsewhere

  var t0 = System.nanoTime()
  val arrSum:Long = arr.sum
  var t1 = System.nanoTime() //all done

  val timePassed = t1-t0;
  val timePassedMilli = timePassed / 1000000.0 //. 0 we want double
  val timePassedSeconds = timePassed / 1_000_000_000.0 //we use _ for ease of use
  println(s"We spent $timePassed nanoSeconds, or $timePassedMilli miliSeconds or $timePassedSeconds seconds to get sum $arrSum")


  def testSeq(mySeq:Seq[Int]): Double = {
    val t0 = System.nanoTime()
    //our speed tests start here
    val seqSum = mySeq.sum

    val t1 = System.nanoTime() //all done
    val timePassedMs = (t1-t0)/1_000_000.0 //.0 is for double
    println(s"sum $seqSum calculated in $timePassedMs mili seconds")
    timePassedMs
  }

  //  testSeq(arr)
  //  testSeq(arr)
  //  val testResults = for (n <- 0 to 10) yield testSeq(arr) // so I am collecting 10 tests

  def getAvg(results:Seq[Double]):Double = (results.sum/results.length*100).round/100

  //  println(s"Average of array results is ${getAvg(testResults)}")

  val vectorSeq = arr.toVector

  def getTestSeqAverage(mySeq:Seq[Int], numberOfTests:Int = 10):Double = {
    val testResults = for (n <- 0 until numberOfTests) yield testSeq(arr)
    val avgTimeMs = getAvg(testResults)
    println(s"Average of ${mySeq.getClass} results is $avgTimeMs")
    avgTimeMs
  }

  getTestSeqAverage(arr)
  getTestSeqAverage(vectorSeq)
  val myList = arr.toList //List has no index
  getTestSeqAverage(myList)
  getTestSeqAverage(Range(0,endNum))

  val myRandoms = for (n <- 0 until endNum) yield nextInt(10_000_000)

  myRandoms.slice(0,30).foreach(println)

  //so why do later calculations get really fast, one hypothesis is that CPU starts using cache memory - memory closer to the CPU

  def testSeqSorting(mySeq:Seq[Int]): Double = {
    println(s"Testing sequence of type ${mySeq.getClass}")
    val t0 = System.nanoTime()
    //our speed tests start here
    val seqSorted = mySeq.sorted //sorting is more intensive than summing

    val t1 = System.nanoTime() //all done
    val timePassedMs = (t1-t0)/1_000_000.0 //.0 is for double
    println(mySeq.slice(0,20).mkString(",")) //i show first 20 items in my sequence
    println(seqSorted.slice(0,20).mkString(","))
    println(s"sorted sequence of ${seqSorted.length} length calculated in $timePassedMs mili seconds")
    timePassedMs
  }

  testSeqSorting(myRandoms)
  val randomArr = myRandoms.toArray
  testSeqSorting(randomArr)
  val randomList = myRandoms.toList
  testSeqSorting(randomList)

  //I chose random numbers because sequential numbers 1,2,3,4 may not give you a good picture of performance due to optimization
}