object UsingTraits extends App with BaseSoundPlayer {
  println("Using Traits already!")
  def play = true
  def close = println("Close")
  def pause = println("Pausing")
  def stop= println("Stopping")
  def resume = {
    println("Lots of work to resume!")
    println("Still resuming")
  }

  superPlay("Waterloo")

  val myDoggy = new Dog()
  myDoggy.speak
  myDoggy.comeToMaster
  myDoggy.eat("Scooby snacks")
  myDoggy.wagTail
  myDoggy.wiggle
  val myKitty = new Cat("Minka")
  myKitty.speak
  myKitty.comeToMaster
  myKitty.eat("Sheeba")
  println(myKitty.name)

  //we can add a trait to an object at the time of creation
  val problemCat = new Cat("Bugger") with Debugger
  problemCat.speak
  problemCat.log("I can also take care of myself")

  val smartCat = new SmartCat("Einstein")
  println(smartCat.add(2,2))
  smartCat.speak
  smartCat.eat("knibbles")
  println(smartCat.name)
}