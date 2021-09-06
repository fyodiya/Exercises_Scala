object FunctionalStyle extends App {
  var total = 0
  def addToTotal(n: Int) = total += n //this is a bad style of coding

  def add(a: Int, b: Int) = a + b //much better
  total = add(total, 5)

  def addWith (a: Int, b: Int) = println(a+b)
  //this is just a very specific printing


}
