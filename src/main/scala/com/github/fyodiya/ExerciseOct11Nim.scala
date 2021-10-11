package com.github.fyodiya

  import scala.io.StdIn.readLine
  import scala.util.Random.nextInt

  object ExerciseOct11Nim extends App {

    //https://en.wikipedia.org/wiki/Nim

    //TODO migrate to Class based design for more organization
    val startingCount = 21
    val gameEndCondition = 0
    val minMove = 1
    val maxMove = 3
    val verbose = true
    val playerCount = readLine("How many players will be playing 1 or 2?").toInt
    val playerA = readLine("Player A what is your name?")
    val playerB = if (playerCount == 2) readLine("Player B what is your name?") else "Computer"
    //TODO add computer level setup here
    val computerLevel = if (playerCount == 1) readLine("computer level is 1")
    var gameState = startingCount
    var isPlayerATurn = true

    def beforeGame(): Unit = {
      println(s"Player A $playerA and Player B $playerB let's play NIM!")
    }

    def mainGameLoop(): Unit = {
  while (gameState > gameEndCondition) {
    val currentPlayer = if (isPlayerATurn) playerA else playerB
    println(s"Currently there are $gameState matches on the table")
    val move = getMove(currentPlayer)
    gameState -= clampMove(move, minMove, maxMove, verbose) //same as gameState = gameState - move
    //TODO limit the number of matches taken
    isPlayerATurn = !isPlayerATurn //toggle a trick to change booleans
    //ask for input
    //change game state
  }
}
    def afterGame(): Unit = {
      val winner = if (isPlayerATurn) playerA else playerB
      val loser = if (!isPlayerATurn) playerA else playerB
      println(s"Game has ended. " +
        s"Congratulations, $winner! Better luck next time, $loser")
    }

    def clampMove(move:Int, min:Int = 1, max:Int = 3, verbose:Boolean = false): Int = {
      if (move > max) {
        if (verbose) println(s"$move is too much, you will have to settle for $max")
        max
      } else if (move < min) {
        if (verbose) println(s"$move is too little, you will have to settle for $min")
        min
      } else {
        move
      }
    }

    /**
     * Calculates the next move
     * @param playerName - player string with "Computer" signifying computer player
     * @return items to take from game board
     */

    def getMove(playerName:String):Int = {
      if (playerName == "Computer") {
        getComputerMove(gameState)
      } else {
        readLine(s"How many matches do you want to take $playerName?").toInt
      }
    }

    def randomComputerMove():Int = nextInt(maxMove) + minMove

    def smartComputerMove(gameState:Int): Int = {
      //so turns out we need some strategy based on reminder
      //only question is whether it is maxMove or was it maxMove + 1
      //no matter what one person takes, the second person can always guarantee that both players take 4 matches
      //one takes 1 -> 3  2 -> 2 3 -> 1
      //so it certainly looks like first person should lose against a computer right?
      //second thing is strategy for computer when it is losing(against a smart player)
      //so we need to do match against reminder of 4
      gameState % 4 match {
        case 0 => 3 // so from 4 to 1 and opponent loses, works for 8, 12, 16, 20
        case 1 => randomComputerMove() //what to do when losing? :) my suggestion is play random then
        case 2 => 1 //so from 2 to 1 and opponent loses, so 2, 6, 10, 14,
        case 3 => 2 //so from 3 to 1 and again opponent loses, so 3, 7, 11, 15,19 and so on
//        case _ => 0 //this default should not happen!!
      }
    }

    def getComputerMove(gameState:Int, level:Int=1): Int = {
      if (level == 1) {2}
      else if (level == 2) {
        randomComputerMove()
      } else {smartComputerMove(gameState)}
    }

    //to start our game
    beforeGame()
    mainGameLoop()
    afterGame()



  }
