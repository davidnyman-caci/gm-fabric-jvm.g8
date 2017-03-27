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
  aggregate(model, business, client, server)

lazy val business = project.
  settings(
    commonSettings,
    name := "$name$-business"
  )

lazy val model = project.
  settings(
    commonSettings,
    libraryDependencies ++= Dependencies.model,
    name := "$name$-model"
  )

lazy val client = project
  .dependsOn(model)
  .settings(
    commonSettings,
    libraryDependencies ++= Dependencies.client,
    name := "$name$-client"
  )

lazy val server = project
  .dependsOn(model, business)
  .settings(
    commonSettings,
    libraryDependencies ++= Dependencies.server,
    name := "$name$-server"
  )
