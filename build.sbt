name := "TDL2018"

version := "0.1"

scalaVersion := "2.12.7"

lazy val akkaVersion = "2.5.1"

libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.0.5" % "test" , 
    "com.typesafe.akka" %% "akka-actor" % akkaVersion
)
