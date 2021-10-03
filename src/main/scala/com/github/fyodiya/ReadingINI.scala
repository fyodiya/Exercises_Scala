package com.github.fyodiya

import org.ini4j.{Ini, IniPreferences, Wini}
import java.io.File
import java.nio.file.{Files, Paths}
import java.time.LocalDateTime

object ReadingINI extends App {

    println("Reading INI files")
    val srcFile = "src/resources/ini/settings.ini"

    val ini = new Ini(new File(srcFile))
    val prefs = new IniPreferences(ini)

    println("My Name is " + prefs.node("People").get("name", null))
    //so we can pass defaults to get
    println("Checking key" + prefs.node("People").get("notarealname", "No Such key"))

    val destFile = "src/resources/ini/newSettings.ini"

    //TODO add check if file exists already
    val path = Paths.get(destFile)
    if (Files.exists(path)) {
      println(s"File path at $path already exists!")
    } else {
      Files.createFile(path)
    }


    val newIni: Wini = new Wini(new File(destFile))

    val now = LocalDateTime.now()

    newIni.put("block_name", "property_name", "value")
    newIni.put("block_name", "property_name_2", 45.6)
    newIni.put("date_block", "lastChanged", now)
    newIni.store()


  //checking if file exists
  //  val path = Paths.get(destFile)
  //  if (Files.exists(Path)) {
  //    println("File already exists")
  //  } else {
  //    Files.createFile(path)
  //  }

}
