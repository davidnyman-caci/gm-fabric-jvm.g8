// give the user a nice default project!
lazy val root = (project in file("."))
  .enablePlugins(RpmPlugin)
  .settings(
    inThisBuild(List(
      organization := "$organization$",
      scalaVersion := "$scalaVersion$",
      name := "$name$"
    ))
  )
  .aggregate(business, model, client, server)

resolvers in ThisBuild ++= Seq(
  "Sonatype" at "http://repository.sonatype.org/",
  "Search Maven" at "http://search.maven.org/",
  "Maven Central" at "http://central.maven.org/maven2/",
  "Twitter Maven" at "http://maven.twttr.com",
  Resolver.mavenLocal
)

lazy val business = project

lazy val model = project.settings(
  libraryDependencies ++= Dependencies.model,
  scroogeThriftSourceFolder in Compile := baseDirectory { base => base / "src/main/thrift" }.value,
  scroogeThriftDependencies in Compile := Seq("finatra-thrift_2.11")
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
