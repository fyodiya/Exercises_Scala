object UsingCommandArgumentsWithApp extends App {
  //so we are in effect running a main function without noticing :)
  println("Starting main function")
  for (arg <- args) {
    //notice args does not give us an error!!
    // because App trait has main function with args parameter defined main with args for us
    println(s"Going to do something with argument: $arg its type is ${arg.getClass}")
  }
  println("All done")
}

