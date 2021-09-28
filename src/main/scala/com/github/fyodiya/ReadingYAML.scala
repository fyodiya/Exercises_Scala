package com.github.fyodiya

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

import java.io.{File, FileInputStream}
import scala.beans.BeanProperty
//import scala.collection.immutable.HashMap

object ReadingYAML extends App {
  val srcPath = "src/resources/yaml/gameConfig.yaml"
  val input = new FileInputStream(new File(srcPath))

  //so we have a file stream, we want to parse it
  //  val yaml = new Yaml()
  val yaml = new Yaml(new Constructor(classOf[GameSettings]))
  ////  val parsedData = yaml.load(input).toString //we will need to specify what data we expect back..
  ////  val parsedData = yaml.load(input).asInstanceOf[HashMap[String, String]] //we will need to specify what data we expect back..
  val settings = yaml.load(input).asInstanceOf[GameSettings]  //so parsing happens here

  //  val yaml = new Yaml(new Constructor(classOf[GameSettingsToo])) //we might get an exception here
  //  val settings = yaml.load(input).asInstanceOf[GameSettingsToo]

  println(settings)
  println(settings.maxStartingMatches)

  //alternative approach with generic java object, when we do not know the full structure
  val newStream = new FileInputStream(new File(srcPath))

  val genericYaml = new Yaml()
  val obj = genericYaml.load(newStream).asInstanceOf[java.util.Map[String, Any]]

  //  https://stackoverflow.com/questions/16918956/convert-java-map-to-scala-map
  import scala.collection.JavaConverters._ //TODO find newere method
  val myScalaMap = obj.asScala.toMap

  for ((key,value) <- myScalaMap) {
    println(s"$key -> $value")
  }


  //  println(parsedData)
}

//so this is Java approach
/**
 * With the Snakeyaml Constructor approach shown in the main method,
 * this class must have a no-args constructor.
 */
class GameSettings {
  @BeanProperty var defaultMatches = 21
  @BeanProperty var minStartingMatches = 5
  @BeanProperty var maxStartingMatches = 15
  @BeanProperty var playerA = "Valdis"
  @BeanProperty var playerB = "Liga"
  //  @BeanProperty var usersOfInterest = new java.util.ArrayList[String]()
  override def toString: String = s"playedA: $playerA, userB: $playerB defaultMatches: $defaultMatches"
}

//challenge would be to rewrite a bit more Scala like with case class
//TODO see on the format
case class GameSettingsToo(defaultMatches: Int
                           , minStartingMatches: Int
                           , maxStartingMatches: Int
                           , playerA: String
                           , playerB: String
                          )