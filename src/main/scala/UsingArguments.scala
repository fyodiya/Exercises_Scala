object UsingArguments {
  //so without extend App
  def main(args:Array[String]) = {
    println("Starting main function")
    for (arg <- args) {
      println(s"Going to do something with argument: $arg its type is ${arg.getClass}")
    }
    println("All done")
  }
}
