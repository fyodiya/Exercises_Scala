package com.github.fyodiya

import java.io.{File, FileInputStream}

class ExerciseYamlParsing extends App {

  val srcPath = "src/resources/yaml/gameConfig.yaml"
  val input = new FileInputStream(new File(srcPath))

  //TODO create a new YAML parser to parse teh input stream
  //TODO output maximums game length (from the sequence we created)
  //modify the game settings

 //extra challenge - get the list of top scores (parse the values of top score)
 //clue - list of Integers


}
