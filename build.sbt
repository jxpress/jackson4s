name := "jackson4s"

organization := "net.jxpress"

version := "0.0.1"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.2.1",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.6.3",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.3",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.6.3",
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.6.3",
  "com.fasterxml.jackson.datatype" % "jackson-datatype-joda" % "2.6.3",
  "org.scala-lang" % "scala-reflect" % "2.11.7",
  "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
)
