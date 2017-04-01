// give the user a nice default project!

lazy val commonSettings = Seq(
  organization := "$organization$",
  scalaVersion in ThisBuild := "$scalaVersion$",
  name := "$name$",
  resolvers ++= Seq(
    "Sonatype" at "http://repository.sonatype.org/",
    "Search Maven" at "http://search.maven.org/",
    "Maven Central" at "http://central.maven.org/maven2/",
    "Twitter Maven" at "http://maven.twttr.com",
    Resolver.mavenLocal
  )
)

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

lazy val client = project.
  dependsOn(model).
  settings(
    commonSettings,
    libraryDependencies ++= Dependencies.client,
    name := "$name$-client"
  )

lazy val server = project.
  enablePlugins(JavaAppPackaging).
  dependsOn(client, business).
  settings(
    commonSettings,
    libraryDependencies ++= Dependencies.server,
    mainClass in Compile := Some("$package$.$appName$"),
    name := "$name$-server"
  )
