object Exercise2ndOfSept extends App {

  val snowball = new Animal ("Snowball", "cat", "food", "meow",2)
  val fluffy = new Animal ("Fluffy", "dog", "barking at cats", "woof", 6)
  val doodle = new Animal ("Doodle", "parrot", "flying", "my name is Doodle, and I am a bird", 4)

  snowball.whatAnimalSays()
  fluffy.whatAnimalSays()
  doodle.whatAnimalSays()

  snowball.meet("food")



}
