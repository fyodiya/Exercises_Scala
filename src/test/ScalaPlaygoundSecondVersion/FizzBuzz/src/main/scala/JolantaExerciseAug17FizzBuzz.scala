object JolantaExerciseAug17FizzBuzz extends App {
  for (i <-1 to 100) {
    if (i % 5 == 0 && i % 7 == 0) {
      println("FizzBuzz")
    }
    else if (i % 5 == 0) {
      println("Fizz")
    }
    else if (i % 7 == 0) {
      println("Buzz")
    }
    else {
      println(i)
    }

  }
}
