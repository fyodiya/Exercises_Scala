name := "ScalaPlayground2021Aug"

version := "0.1"

scalaVersion := "2.13.6"

// https://mvnrepository.com/artifact/com.lihaoyi/upickle
libraryDependencies += "com.lihaoyi" %% "upickle" % "1.4.1"

javacOptions ++= Seq( "-encoding", "UTF-8" )

// https://mvnrepository.com/artifact/org.scala-lang.modules/scala-xml
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.0.1"

// https://mvnrepository.com/artifact/org.yaml/snakeyaml
libraryDependencies += "org.yaml" % "snakeyaml" % "1.29"

// https://mvnrepository.com/artifact/org.ini4j/ini4j
libraryDependencies += "org.ini4j" % "ini4j" % "0.5.4"

// https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc
libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.36.0.3"