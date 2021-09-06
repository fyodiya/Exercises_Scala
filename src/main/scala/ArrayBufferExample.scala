import scala.collection.mutable.ArrayBuffer
//immutables are available without import
//mutables you have to import

object ArrayBufferExample extends App {
  val numbers = (0 to 10).toArray

  //sometimes we want to use mutable data structures
  val squareBuffer = ArrayBuffer[Int]() //this is empty buffer of Integers
  //so by saying val i am saying I am not going to change the buffer, but its contents and size can be changed
  //because it is from mutable collection

  for (n <- numbers) {
    squareBuffer += n*n //so I am adding the squares one by one to my buffer
  }
  squareBuffer.foreach(println)
  //generally once the job on the buffer is done and you are not expecting any new additions
  //you transform buffer into a immutable structure
  val squares = squareBuffer.toArray
  //immutable versions are also going to be quicker for performance (of course that is apparent on larger bigger data set
  squares.foreach(println)
  //foreach is asking for a function which does something with the element
  //so full syntax would be
  squares.foreach(el => println(el))
  //with full syntax we can do more stuff
  squares.foreach(el => println(s"Look ma, I am printing $el"))

  //we could even use foreach to add elements to buffer
  //in Scala this is generally not recommended , better to use map or yield
  squares.foreach(n => squareBuffer += n) //so i am going to add squares to my buffer (squares itself is immutable)
  squareBuffer.foreach(println)
  //if i want to print contents of some Array like strucure we can use mkString
  println(squareBuffer.mkString("(", ",", ")"))
  //I could get silly with this ...
  println(squareBuffer.mkString("<[", "::*::", "]>"))

  //so how about changing values in our ArrayBuffer and Array
  numbers(3) = 300 //so Array even though it is immutable in size, you can still mutable individual values
  println(numbers.mkString("(", ",", ")"))
  //we can of course mutate our ArrayBuffer
  squareBuffer(17) = 9090
  println(squareBuffer.mkString("(", ",", ")"))
  println(s"we have ${squareBuffer.length} elements in our buffer")
}
