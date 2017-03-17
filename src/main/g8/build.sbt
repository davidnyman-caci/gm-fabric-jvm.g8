// give the user a nice default project!
lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "$organization$",
      scalaVersion := "$scalaVersion$",
      name := "$name$"
    )),
    resolvers ++= Seq(
      "Sonatype" at "http://repository.sonatype.org/",
      "Search Maven" at "http://search.maven.org/",
      "Maven Central" at "http://central.maven.org/maven2/",
      "Twitter Maven" at "http://maven.twttr.com"
    )
  )

lazy val business = project

lazy val model = project.settings(
  libraryDependencies ++= Dependencies.model
)

lazy val client = project
  .dependsOn(model)
  .settings(
    libraryDependencies ++= Dependencies.client
  )

lazy val server = project
  .dependsOn(model, business)
  .settings(
    libraryDependencies ++= Dependencies.server
  )
