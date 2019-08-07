name := "first_app"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaJpa
)

libraryDependencies ++= Seq(
  "org.springframework" % "spring-context" % "4.0.0.RELEASE",
  "org.hibernate" % "hibernate-core" % "3.6.9.Final",
  "org.hibernate" % "hibernate-annotations" % "3.5.6-Final",
  "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final"// replace by your jpa implementation
)



play.Project.playJavaSettings
