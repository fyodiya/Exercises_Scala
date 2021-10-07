package com.github.fyodiya

object ExtractingEmail extends App {

  val srcFile = "src/resources/final_project_participants.txt"
  val lines = Utilities.getLinesFromFile(srcFile)
  println(lines.size)

  //if e-mail are "hiding", we need more powerful tool for extraction
  //fully compliant regex for emails is super-complicated

  val emailRegex = ".* (\\s+@\\s+\\.\\s+).*".r
  //so we match every character until space then what we want is following:
  //(some NON whitespaces @ some NON whitespaces . some NON whitespaces)

  val emailRegex(email) = lines.head
  println(lines.head)

  lines.head match {
    case emailRegex(email) => println(s"We got email $email")
    case _ => println(s"We got no matches with regex")

  }

}
