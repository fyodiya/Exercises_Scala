package com.github.fyodiya

import upickle.default.{ReadWriter => RW, macroRW}

//so we have defaults for all properties/values
case class Recipe(title:String="", href:String="", ingredients:Array[String]=Array(""), thumbnail:String="")

object Recipe{
  implicit val rw: RW[Recipe] = macroRW //we will use this to write back our caseClasses to strings
}