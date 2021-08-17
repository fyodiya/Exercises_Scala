object WhileLoops extends App {
println("Alice did")
  println("talk")
  println("talk")
  println("talk")

  var i = 0
  while (i < 10) {
    println(s"talking when i is $i")
  i = i + 1 //increment the counter
  }

  //so while loops run while the conditions in parenthesis are true
var floor = 5 //for while loops our condition has to ba variable since we're going to be changing
  while (floor > 0) {
    println(s"Taking the elevator now at the floor $floor")
  floor -= 1 //which is the same as floor -1
  }
}
