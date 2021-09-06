object Variables extends App {
  println("Scala has two kind of variables, val and var")
  val a = 15 //values stay constant, in some other languages they are called constants
  val b = 6 //b represents just a number, silly comment
  var c = a + b //so c can be changed as many times as we wish (as long as it remains an whole number  integer)
  println(a,b,c)
  c = a*b //values can not be changed
  //in Scala we start by using values and only when absolutely necessary we use variables
  println(a,b,c)
  c = 55
  println(a,b,c)
//  println(a,b,c,d) //bad idea we are using d before it is created
  val d = a+b+c
  println(a,b,c,d)
  println("a+b=", a+b)

  val msg = "Hello, world!"
  println(msg)
  val mySum = a+b
  println(s"$a added to $b equals $mySum") //using s - string interpolation it lets us add variables inside our strings

  //Scala is strongly statically typed - meaning each variable and value has a specific type

  val myInteger:Int = 20 // :Int is not required , because Scala can figure out the type from 20

  var myNumber = 15
  println(myNumber)
  myNumber = 20
  println(myNumber)
//  myNumber = "Cant do this" //in Scala you can not change data types of variables , of course values can not be changed at all
  val myString:String = "Just a string Kaķis" //again :String is not required
  //Strings in Scala fully support Unicode meaning you can write any character from any language inside string
  println(myString)

  //one of the biggest challenges in programming is how to name things :)
  // x and y are great val and var names if they refer to x and y coordinates
  // x and y are not so good for say saving your name or your age
  //also i, and it will be used later for looping
  // and c often represents a single character
  // f might stand for a file, but better to name it fileName

  val myName = "Valdis" //so this would be a good val name
  val lastName = "Saulespurens"
  println(s"Why hello there $myName $lastName")

  //in Scala we use something called camelCase for values, variables and many other things
  //but not for Objects those start with CapitalLetter
  val l = 333 //bad name, since l in many fonts is hard to distinguish from 1 or I

  //so takeaway is to use reasonably short but descriptive names for your variables

  //bad name for variable below
  val ps = 0.27 //you would have to write a comment that ps means price of salt, but still better would be to use longer name
  //better would be
  val priceSalt = 1.27 //this is new data type - double, meaning it is a double precision floating point number
  val kgBought = 15
  val purchaseTotal = priceSalt * kgBought

  val purchaseMessage = s"$myName bought $kgBought kilos of salt at $priceSalt each. He paid $purchaseTotal total"
  println(purchaseMessage)

  val purchaseRounded = purchaseTotal.round //so round actually rounds to nearest integer
  println(s"Actually the total price was $purchaseRounded Euros")


  val purchaseRounded2Digits = (purchaseTotal*100).round.toDouble/100 //we need to cast to Double because round gives us Long integer
//  val purchaseRounded2Digits = (purchaseTotal*100).round/100 //this would still give us 4 because integers have no commas...
  println(s"With 2 digits after comma was $purchaseRounded2Digits Euros")

  //we can print out the data types usually there is no need since we can just use our editor
  println(a.getClass, myName.getClass, purchaseRounded2Digits.getClass)

  val myFloat = a.toFloat //I can cast a to floating point
  val myDouble = a.toDouble //casting integer to double
  val myAString = a.toString //I can change number to string
  println(a, myFloat, myDouble, myAString)

  //going from string to number well not always possible
  val myNumberFromString = "1432566".toInt //this will work
  println(myNumberFromString)
//  val myNameNumber = myName.toInt //well what will happen here.. // we will get NumberFormatException

  val priceOfSaltConverted = priceSalt.toInt //so what will happen to our 1.27 price
  println(priceOfSaltConverted) //it is 1 since integers do not store data after comma

  val bigNumber = 2421415620373532L //by adding L I make number into Long
  println(bigNumber, bigNumber.toInt, bigNumber.toShort, bigNumber.toByte)
  println(Long.MinValue, Long.MaxValue, Int.MinValue,Int.MaxValue)
  println(Short.MinValue, Short.MaxValue, Byte.MinValue, Byte.MaxValue)

  val num = 130
  println(num, num.toByte)
  //when we go to Byte well we start at at -128 instead of 129, then -127 instead of 129 and , -126 instead of original 130 and so on and so on

  val sizeOfByte = Math.pow(2,8) //one byte is 8 bits meaning 8 0s or 1s
  val sizeOfInteger = Math.pow(2, 32) //we moved most computers from 32bits to 64 bits because 32 bits is not enough
  //to address our memory
  val sizeOfLong = Math.pow(2, 64) //with 64 bits we are good for next couple hundred years :)

  println(sizeOfByte, sizeOfInteger, sizeOfLong)

  val face = '☺' // a single Unicode character, notice the single quotes instead of double
  val faceValue = face.toInt
  println(face, faceValue)

  //more about Scala types https://docs.scala-lang.org/tour/unified-types.html

  //basic type Boolean , represents singe on/off, 1/0 value
  val isCold = false
  val isRaining = false
  val isSummer = true

  println(isCold,isRaining,isSummer)

  println('a'.toInt) //this will give us ASCII and also Unicode value for a
//  println("a".toInt) //this should not work because a as a string does not convert to a number
  //so single quotes 'v' reprsent a character but "v" represents a string

}
