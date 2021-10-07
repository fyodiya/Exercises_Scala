package com.github.fyodiya

import scala.collection.mutable.ListBuffer

object DBTest extends App {
  val dbPath = "./src/resources/db/chinook.db"
  val url = "jdbc:sqlite:"+dbPath  //the prefix will change depending on your database type here we have sqlite

  import java.sql.DriverManager

  val conn = DriverManager.getConnection(url)
  println(conn.getClientInfo())

  val statement = conn.createStatement() //Creates a Statement object for sending SQL statements to the database.

  val tableName = "genres"
  val sql =
  s"""
       |SELECT * FROM $tableName
       |""".stripMargin
  //FIXME very careful with adding strings directly to our sql queries
  //if you do not control tableName you run a risk of SQL injection

  val resultSet = statement.executeQuery(sql)
  val meta = resultSet.getMetaData
  println(s"We have ${meta.getColumnCount} columns")
  println(s"We have table ${meta.getTableName(1)} where column 1 came from" )


  var colSeq = ListBuffer[String]() //buffer type collections are ideal when we are adding to some results
  for (i <- 1 to
  meta.getColumnCount) {
  println(meta.getColumnName(i)) //notice we are using 1 based well columns are 1 based index
  colSeq += meta.getColumnName(i)
}
  println(colSeq)

  //alternative using yield
  val colNames = for (i <- 1 to
  meta.getColumnCount) yield {
  //    println(meta.getColumnName(i)) //notice we are using 1 based well columns are 1 based index
  meta.getColumnName(i)
}
  colNames.foreach(println)

  //we need some sort of buffer to temporarily save the results
  val genreBuffer = scala.collection.mutable.ListBuffer.empty[Genres]
  //so very typical to get results in a while loop from database sine the query could be quite large
  while ( resultSet.next() ) {
  //if we know the column name we can get results for that particular row
  //    print(resultSet.getString("GenreId"))
  //    print(" -> ")
  //    println(resultSet.getString("Name"))
  //    colSeq.foreach(col => print(col, resultSet.getString(col))) //this prints a tuple for each column entry
  //    println()
  val genre = Genres(resultSet.getInt("GenreId"), resultSet.getString("Name"))
  println(genre)
  //      genreBuffer += genre
  genreBuffer.append(genre)  //same as above
}
  val genreCollection = genreBuffer.toArray

  //we print ids 6,7,8 since IDs started with 1 but slicing start with 6th element (index 5)
  // but does not include 9th element(index 8)
  genreCollection.slice(5,8).foreach(println)
}