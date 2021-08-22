object WhileLoops extends App {

println("Alice did")
  println("talk")
  println("talk")
  println("talk")
  //what should we do if we want to repeat the action lets say 50 times?
  //copying and pasting wouldn't be productive

  var i = 0
  //so while loops run while the condition is true
  while (i < 10) {
    println(s"Alice is talking when i is $i")
    //we must add one more thing
    i = i +1 //it's called "incrementing the counter"
  }
//there is room for forever loops, in some applications




}
