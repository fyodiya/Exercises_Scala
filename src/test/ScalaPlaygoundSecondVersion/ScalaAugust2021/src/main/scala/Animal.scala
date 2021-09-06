//add class variables - name, type, likes, sound - all strings, age - Int
// add class method makeSound which prints sound
//add class method meet which has a parameter of string
// this meet should decide whether the animal likes the person whom they greet
// or run away if they don't like that person, this contact

class Animal(var name: String, var animalType: String, var likes: String, var sound: String, var age: Int) {

  def makeSound () = println (s"$sound")

  def whatAnimalSays () = {
    val itsType = animalType
    println(s"here we meet our animal, it is $animalType")
    val animalName = name
    println(s"it's name is $animalName")
    val whatItLikes = likes
    println(s"it likes $whatItLikes")

    println(s"what does $name says?")
    println(s"it says $sound")
  }

  def meet (contact:String): Unit = {
    if (contact == likes) println("greet")
    else println("run away")
  }



}
