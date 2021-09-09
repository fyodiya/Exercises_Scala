// Scala program to illustrate the
// implementation of inheritance

// Base class
class Geeks {
  var Name: String = "Ankita"
  def simplePrint: Unit = println(s"name is $Name")

  //we can override existing methods that are built-in
  //e.g., having print give me my custom print
  override def toString: String = s"Object of class ${getClass.getName} custom name: $Name"
//we have created our own custom string to be used whenever we use PRINTLN in this class
}

// Derived class
// Using extends keyword
class Geeks2 extends Geeks //so we use this feature EXTENDS also here
{
  var Article_no: Int = 130

  // Method
  def details
  {
    println("Author name: " +Name);
    println("Total numbers of articles: " +Article_no);
  }
//we are overriding already existing function of our own system of pre-built in scala functions
  //we have a choice to call it super.


  override def simplePrint: Unit = {
    super.simplePrint //this calls the original simplePrint of the parent not always needed
  println(s"My own printing of article: $Article_no")
  }

  class Socket(var timeout: Int = 2000, var linger: Int = 3000) {
    override def toString = s"timeout: $timeout, linger: $linger"
  }
  //we can rewrite default values, so we can can create different objects with different values


  object Main
  {
    // Driver code
    //defining main function is an alternative to usage of EXTENDS APP
    def main(args: Array[String])
    {
      val mainOb = new Geeks
      println(mainOb.Name)
      mainOb.simplePrint //I can skip parenthesis

      // Creating object of derived class
      val ob = new Geeks2;
      ob.Name = "Loki"
      ob.details
      ob.simplePrint
      println(ob)

      val socketA = new Socket
      val socketB = new Socket (1500)
      val socketC = new Socket(2000, 4000)
      println(socketA)
      println(socketB)
      println(socketC)

      val cars = for (n <- 0 to 4) yield Car()
      //we will have cars with identical properties, but they'll be different objects
      cars.foreach(println)

      val vw = Car(make = "VW", color = "grey", model = "newest one")
      println(vw)

    }
  }
}