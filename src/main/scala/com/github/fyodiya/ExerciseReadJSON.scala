package com.github.fyodiya

import scala.collection.mutable
import scala.io.Source
import upickle.default._

object ExerciseReadJSON extends App {

  //TODO read raw recipes.JSON
  val recipePath = "src/resources/json/recipes.json"
  val bufferedSource = Source.fromFile(recipePath)
  val rawString = bufferedSource.mkString("")
  println(rawString)

  //TODO parse into value by using upickle
  val data = ujson.read(rawString)
  println(data(1)("title"))
 // println(data(1)("NoSuchTitle"))

  //TODO convert to array of values
  val arrValues = data.arr.toArray //arr was giving buffer, but we want fixed sized
  println(arrValues(0))

  //TODO convert to array of hashmaps
  val seqObjects = arrValues.map(myValue => myValue.obj)
  seqObjects.slice(0,3).foreach(println)

  //TODO print the recipes out
  val firstRecipe = createRecipe(seqObjects.head) //or seqObjects(0)
  println(firstRecipe)
  println(firstRecipe.ingredients.mkString(","))
  //BONUS create a Recipe case class and actually parse into Array of Recipe s //this could take a bit longer

  //  val allRecipes = seqObjects.map(hMap => createRecipe(hMap)) //full syntax
  //    val allRecipes = seqObjects.map(createRecipe(_)) //shorter
  val allRecipes = seqObjects.map(createRecipe) //super short, works because createRecipe only takes one parameter of cour type

  allRecipes.slice(0,3).foreach(println)

  val jsonText = write(firstRecipe)
  println(jsonText)

  val allRecipeJson = write(allRecipes)
  println(allRecipeJson)

  //so we made a funtion to check for ingredient
  def isNeedlePresent(ingredients: Array[String], needle:String):Boolean = {
    val goodIngredients = ingredients.filter(item => item.contains(needle))
    goodIngredients.length > 0 //so if 0 that will be false meaning no needle present
  }

  //  val onionRecipes = allRecipes.filter(recipe => recipe.ingredients.contains(" onions"))
  val onionRecipes = allRecipes.filter(recipe => isNeedlePresent(recipe.ingredients, "onion"))
  println(onionRecipes.length)
  onionRecipes.foreach(println)

  val onionJSON = write(onionRecipes, indent = 4) //indent for human readability

  Utilities.saveText( "src/resources/json/onions.json", onionJSON)
}