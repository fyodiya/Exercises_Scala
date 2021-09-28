package com.github.fyodiya
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

import java.io.{File, FileInputStream}
import java.util.Arrays.stream
import scala.beans.BeanProperty

object ReadingYAML extends App {

  val srcPath = "src/resources/yaml/gameConfig.yaml"
  val input = new FileInputStream(new File(srcPath))
//val settings = yaml.load(input)
//  //we have a file stream, but we want too parse it
//  val yaml = new Yaml()

  //val parsedData = yaml.load(input).toString //we need to specify what data we expect back
//  val parsedData = yaml.load(input).asInstanceOf[mutable.HashMap[String,String]]
//val parsedData = yaml.load(input)
//  println(parsedData)

  val yaml = new Constructor(classOf[GameSettings])
  val settings = yaml.load(input).asInstanceOf[GameSettings]
  println(settings)

  case class GameSettings() {
    @BeanProperty var defaultMatches = 21
    @BeanProperty var minStartingMatches = 5
    @BeanProperty var maxStartingMatches = 15
    @BeanProperty var playerA = "Valdis"
    @BeanProperty var playerB = "Līga"
    override def toString: String = s"playerA: $playerA, userB: $playerB, default matches: $defaultMatches"
    println(settings)
  }

    val newStream = new FileInputStream(new File(srcPath))

  val genericYaml = new Yaml()

  val obj = yaml.load(newStream.asInstanceOf[java.util.Map{String, Any}]
    val myScalaMap = obj.asScala.toMap



}
