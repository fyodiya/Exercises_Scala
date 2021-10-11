package com.github.fyodiya

import scala.io.StdIn.readLine

object Nim extends App {

  //TODO support 2 player mode
  //TODO support computer mode
  //TODO add different computer skill levels


  //TODO migrate to class based design for some organization
  var startingCount = 21
  val gameEndCondition = 0
  var gameState = startingCount //gameState will keep the score
  val playerA = readLine("What is Your name?")
  val playerB = readLine("What is Your name?")

  var isPlayerATurn = true
   println(s"Player A $playerA and player B $playerB, let's play a game of NIM!")

  while (gameState > gameEndCondition) {
    val currentPlayer = if (isPlayerATurn) playerA else playerB
    println(s"currently there are $gameState matches on the table!")
    val move = readLine(s"How many matches do you want to take $currentPlayer?")
    gameState -= move //same as gameState = gameState - move
    isPlayerATurn = !isPlayerATurn //toggle a trick to change booleans
    //ask for input
    //change your state

  }
  val winner = if (isPlayerATurn) playerA else playerB
  val loser = if (isPlayerATurn) playerB else playerA
  println(s"Game has ended. Congratulations, $winner! Better luck next time, $loser.")

}
