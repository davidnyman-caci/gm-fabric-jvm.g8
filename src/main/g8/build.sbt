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
  ),
  mainClass in Compile := Some("$package$.$appName$"),
  assemblyMergeStrategy in assembly := {
    case "BUILD" => MergeStrategy.discard
    case PathList("org", "apache", "log4j", xs @ _*) => MergeStrategy.last
    case PathList("META-INF", "io.netty.versions.properties") => MergeStrategy.first
    case PathList("scala", "tools", "nsc", xs @ _*) => MergeStrategy.last
    case other => MergeStrategy.defaultMergeStrategy(other)
  }
)

lazy val root = (project in file(".")).
  enablePlugins(JavaServerAppPackaging).
  settings(
    commonSettings,
    mainClass in assembly := Some("$package$.$appName$")
  ).
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
