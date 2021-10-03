package com.github.fyodiya

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

import java.io.{File, FileInputStream, FileWriter}
import scala.beans.BeanProperty
import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`

class ExerciseYamlParsing extends App {

  val srcPath = "src/resources/yaml/gameConfig.yaml"
  val input = new FileInputStream(new File(srcPath))
  val yaml = new Yaml(new Constructor(classOf[BigGameSettings]))
  //TODO create a new YAML parser to parse the input stream
  val newStream = new FileInputStream(new File(srcPath))

//  val genericYaml = new Yaml()
//  val obj = genericYaml.load(newStream).asInstanceOf[java.util.Map[String, Any]]

  //TODO output maximums game length (from the sequence we created)
  //modify the game settings
  val settings = yaml.load(input).asInstanceOf[BigGameSettings]
  println(settings.gameLength)

  settings.topScore.foreach(println)

  //extra challenge - get the list of top scores (parse the values of top score)
  //clue - list of Integers


  settings.topScore.add(900)
  //IN PLACE modification
  val destPath = "src/resources/yaml/newSettings.yaml"

  def writer: FileWriter = new FileWriter(destPath)
yaml.dump(settings, writer)


}
  /**
   * With the Snakeyaml Constructor approach shown in the main method,
   * this class must have a no-args constructor.
   */
  class BigGameSettings {
    @BeanProperty var defaultMatches = 21
    @BeanProperty var minStartingMatches = 5
    @BeanProperty var maxStartingMatches = 15
    @BeanProperty var playerA = "Valdis"
    @BeanProperty var playerB = "Liga"
    @BeanProperty var maximumScore = "1000"
    @BeanProperty var gameLength = 30
    @BeanProperty var topScore = new java.util.ArrayList[Int]()


    //  @BeanProperty var usersOfInterest = new java.util.ArrayList[String]()
    override def toString: String = s"playedA: $playerA, userB: $playerB defaultMatches: $defaultMatches"
  }

