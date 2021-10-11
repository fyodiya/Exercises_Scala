package com.github.fyodiya

import scala.io.StdIn.readLine

object Nim extends App {

  //TODO support 2 player mode
  //TODO support computer mode
  //TODO add different computer skill levels


  //TODO migrate to class based design for some organization
  var startingCount = 21
  val gameEndCount = 0
  var gameState = startingCount //gameState will keep the score
  val playerA = readLine("What is Your name?")
  val playerB = readLine("What is Your name?")

  var isPlayerATurn = true
   println(s"Player A $playerA, let's play a game of NIM!")



}
