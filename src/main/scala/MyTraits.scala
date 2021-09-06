trait MyTraits {

}

trait BaseSoundPlayer {
  def play
  def close
  def pause
  def stop
  def resume
  def superPlay(track: String) = println(s"Playing $track") //we can also implement functionality
}

trait Tail {
  def wagTail { println("tail is wagging") }
  def stopTail { println("tail is stopped") }
}

trait Ears {
  def wiggle //abstract will need implementation whoever extends this trait
}

trait Pet {
  def speak { println("Yo") } // concrete implementation
  def comeToMaster // abstract method it has to be implemented by whichever class or object using it
  def eat(food:String) = println(s"I am eating $food")
}
class Dog extends Pet with Tail with Ears{
  // don't need to implement 'speak' if you don't need to
  def comeToMaster { println("I'm coming!") }
  def wiggle = println("Wiggling my ears")
}

class Cat(var name:String) extends Pet {
  // override the speak method
  override def speak { println("meow") }
  def comeToMaster { println("That's not gonna happen.") }
  override def eat(food:String) = println(s"I am devouring $food with gusto!")
}

trait Debugger {
  def log(message: String) {
    // do something with message
    println(s"This $message should really be saved to a log file")
  }
}

trait Calculator {
  def add(a:Int, b:Int):Int
  def sub(a:Int, b:Int):Int
}

//so this is the way to pass along some parameter at the class creation time
class SmartCat(name:String) extends Cat(name) with Calculator {
  def add(a:Int, b:Int):Int = a+b+10
  def sub(a:Int, b:Int):Int = a-b+100 //these cats might be too smart...
}
