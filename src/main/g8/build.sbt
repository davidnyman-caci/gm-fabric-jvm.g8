// give the user a nice default project!

lazy val commonSettings = Seq(
  organization := "$organization$",
  scalaVersion := "$scalaVersion$",
  name := "$name$",
  resolvers ++= Seq(
    "Sonatype" at "http://repository.sonatype.org/",
    "Search Maven" at "http://search.maven.org/",
    "Maven Central" at "http://central.maven.org/maven2/",
    "Twitter Maven" at "http://maven.twttr.com",
    Resolver.mavenLocal
  )
)

lazy val root = (project in file(".")).
  enablePlugins(RpmPlugin).
  settings(commonSettings).
  aggregate(model, business)

lazy val business = project

lazy val model = project.
  settings(
    commonSettings,
    libraryDependencies ++= Dependencies.model
  )

lazy val client = project
  .dependsOn(model)
  .settings(
    commonSettings,
    libraryDependencies ++= Dependencies.client
  )

lazy val server = project
  .dependsOn(model, business)
  .settings(
    commonSettings,
    libraryDependencies ++= Dependencies.server
  )
