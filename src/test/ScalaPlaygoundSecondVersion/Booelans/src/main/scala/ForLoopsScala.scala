object ToLoopsScala extends App {
  //we can do everything while loops but for loops offer us convenience

  //we use for loops when we know exact number of items to go through
  for (i <- 0 to 5) {
    println(s"i is now $i")
  }
  for ( i <- 0 until 5) {
      println(s"i is now $i")
  }

}
