import FunctionalStyle.total

object Exercise6thOfSeptReadingArguments {
  //TODO either with extend App or def main (choose one!)
  def main(args:Array[String]) = {
    println("Starting main function")
    //TODO read all arguments
    val argCount = args.length
    println(s"We got ${argCount} arguments")
    //    var total = 0.0
    var total:Double = 0 //also works
    for (arg <- args) {
      println(s"Going to do something with argument: $arg its type is ${arg.getClass}")
      total += arg.toDouble
    }
    println(s"Sum of all elements is $total")

    //all of the arguments in args are strings
    //so assuming we know those are strings that can be numbers
    //we could do the following which is more functional programming like
    val myNumbers = args.map(_.toDouble) //same as (item => item.toDouble)
    val numberSum = myNumbers.sum //so same as total
    println(s"Also sum of all elements is $numberSum")

    //we could also do the yield which as we remember translate to map underneath
    val myNumbersAlso = for (arg <- args) yield arg.toDouble
    val numberSumAlso = myNumbersAlso.sum
    println(s"Finally sum of all elements is $numberSumAlso")

    val avg = total / argCount
    println(s"Average of all elements is $avg")
  }

  
}