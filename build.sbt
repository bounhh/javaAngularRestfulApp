name := "projet"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  filters,
  javaJdbc,
  javaEbean,
  cache
)     

play.Project.playJavaSettings

