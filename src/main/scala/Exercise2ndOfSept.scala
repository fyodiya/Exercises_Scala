object Exercise2ndOfSept extends App {

  val snowball = new Animal ("Snowball", "cat", "food", "meow",2)

  snowball.whatAnimalSays()
  snowball.makeSound()

  snowball.meet("food")
  snowball.meet("fluffy")

  val fluffy = new Animal ("Fluffy", "dog", "barking at cats", "woof", 6)
  val doodle = new Animal ("Doodle", "parrot", "flying", "my name is Doodle, and I am a bird", 4)

  fluffy.makeSound()
  doodle.makeSound()

  //it is possible to build a class that already utilizes an existing class as a reference
  //we can define cat or mouse classes
  //which uses most of the ANIMAL properties/blueprints


}
