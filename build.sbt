name := "ScalaPlayground2021Aug"

version := "0.1"

scalaVersion := "2.13.6"

// https://mvnrepository.com/artifact/com.lihaoyi/upickle
libraryDependencies += "com.lihaoyi" %% "upickle" % "1.4.1"

javacOptions ++= Seq( "-encoding", "UTF-8" )

// https://mvnrepository.com/artifact/org.scala-lang.modules/scala-xml
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.0.1"
