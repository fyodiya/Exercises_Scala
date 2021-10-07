package com.github.fyodiya

import com.github.fyodiya.DBTest.statement

import java.sql.DriverManager
import scala.collection.mutable.ListBuffer

object ExerciseOctober7SQL extends App {
  val dbPath = "./src/resources/db/chinook.db.db"
  val url = "jdbc:sqlite:"+dbPath
  val conn = DriverManager.getConnection(url)
  println(conn.getClientInfo())

  val statement = conn.createStatement()
  //connect to database and extract ALL artist data into an Array of Artist case class
  val tableArtists = "artists"
  val sqlArtist =
    s"""
       |SELECT * FROM $tableArtists
       |""".stripMargin
  val resultSet = statement.executeQuery(sqlArtist)
  val meta = resultSet.getMetaData

  var colSeq = ListBuffer[String]() //buffer type collections are ideal when we are adding to some results
  for (i <- 1 to
    meta.getColumnCount) {
    println(meta.getColumnName(i)) //notice we are using 1 based well columns are 1 based index
    colSeq += meta.getColumnName(i)
  }
  println(colSeq)
  val artistBuffer = scala.collection.mutable.ListBuffer.empty[Artists]
  //so very typical to get results in a while loop from database sine the query could be quite large
  while ( resultSet.next() ) {
    //if we know the column name we can get results for that particular row
    //    print(resultSet.getString("GenreId"))
    //    print(" -> ")
    //    println(resultSet.getString("Name"))
    //    colSeq.foreach(col => print(col, resultSet.getString(col))) //this prints a tuple for each column entry
    //    println()
    val artists = Artists(resultSet.getInt("ArtistId"), resultSet.getString("Name"))
    println(artists)
    artistBuffer += artists
    //    artistBuffer.append(artists)  //same as above
  }
  val artistCollection = artistBuffer.toArray



}
