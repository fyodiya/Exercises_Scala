object SeqSpeedTest extends App {
println("Lets test various scala sequence type data structures")

  val endNum = 100
  val arr = (0 to endNum).toArray
  val t0 = System.nanoTime()
  val arrSum:Long = arr.sum

  val t1 = System.nanoTime()
 //all done
 val timePassed = t1 - t0
  val timePassedMilli = timePassed / 1000000.0 //.0 because we want Double
  val timePassedSeconds = timePassed / 1_000_000_000.0
 println(s"We have spend $timePassed or $timePassedMilli nano seconds on this task to get sum $arrSum")

def testSeq(mySeq: Int): Double = {
  val t0 = System.nanoTime()
  //our speed tests start here
  val seqSum = mySeq.sum
  var t1 = System.nanoTime() //all done
  var timePassedMs = (t1 - t0) / 1_000_000.0
  println(s"sum $seqSum calculated in $timePassedMs milliseconds")
  timePassedMs
}

  testSeq(arr) : Int
  testSeq(arr) : Int
  val testResults = for (n <- 0 to 10) yield testSeq(arr) : Int

  def getAvg (results: Seq[Int]): Double = (results.sum/results.length*100).round/100

  println(s"average of array results is ${getAvg(testResults)}")





}
