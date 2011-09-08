name := "tictactoe"

organization := "org.example"

scalaVersion := "2.9.0-1"

scalacOptions ++= Seq("-deprecation",
        "-unchecked",
        "-Xmigration",
        "-Xcheckinit",
        "-encoding", "utf8")

javacOptions ++= Seq(
                  "-Xlint:deprecation"
                 )