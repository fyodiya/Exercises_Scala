package com.github.fyodiya

import scala.io.StdIn.readLine

object Nim extends App {

  //TODO support 2 player mode
  //TODO support computer mode
  //TODO add different computer skill levels


  //TODO migrate to class based design for some organization
  val startingCount = 21
  val gameEndCondition = 0
  val minMove = 1
  val maxMove = 3
  val verbose = true
  val playerCount = readLine("How many players will be playing 1 or 2?").toInt
  val playerA = readLine("Player A what is your name?")
  val playerB = if (playerCount == 2) readLine("Player B what is your name?") else "Computer"
  var gameState = startingCount
  var isPlayerATurn = true

   println(s"Player A $playerA and player B $playerB, let's play a game of NIM!")

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


  def getMove(playerName:String):Int = {
    if (playerName == "Computer") {
      getComputerMove(gameState)
    } else {
      readLine(s"How many matches do you want to take $playerName?").toInt
    }
  }

  //TODO create 3 levels
  def getComputerMove(gameState:Int, level:Int=1) = {
//so 1st level is here
    2
    //TODO level 2
    //TODO level 3

  }

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

  val winner = if (isPlayerATurn) playerA else playerB
  val loser = if (isPlayerATurn) playerB else playerA
  println(s"Game has ended. Congratulations, $winner! Better luck next time, $loser.")


}
