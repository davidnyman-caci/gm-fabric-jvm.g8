import sbt._

object Version {
  val scrooge= "4.14.0"
  val twitterUtil = "6.41.0"
  val finagle = "6.42.0"
  val twitterServer = "1.27.0"
  val finatra = "2.8.0"
  val guiceInjection = "4.0"
  val logBack = "1.1.2"
  val slf4j = "1.7.9"
  val log4j = "1.2.15"
  val junit = "4.10"
  val mockito = "1.9.5"
  val scalaTest = "3.0.1"
  val gmFabricCore = "0.1.0"
  val guice = "4.0"
}

object Library {

  val twit = "com.twitter"
  val scrooge = twit %% "scrooge-core" % Version.scrooge
  val finagleCore = twit %% "finagle-core" % Version.finagle
  val utilCore = twit %% "util-core" % Version.twitterUtil
  val finagleThrift = twit %% "finagle-thrift" % Version.finagle exclude("org.slf4j", "slf4j-log4j12")
  val finagleStats = twit %% "finagle-stats" % Version.finagle
  val serverSets = twit %% "finagle-serversets" % Version.finagle % "runtime" exclude("org.slf4j", "slf4j-jdk14") exclude("org.slf4j", "slf4j-log4j12")
  val log4j = "log4j" %% "log4j" % Version.log4j
  val slf4jApi = "org.slf4j" % "slf4j-api" % Version.slf4j
  val junit = "junit" % "junit" % Version.junit % "test"
  val finatra = twit %% "finatra" % Version.finatra
  val twitterServer = twit %% "twitter-server" % Version.twitterServer
  val gmFabricCore = "com.deciphernow" % "gm-fabric-core" % Version.gmFabricCore
  val mockito = "org.mockito" % "mockito-core" % Version.mockito % "test"
  val logbackCore = "ch.qos.logback" % "logback-core" % Version.logBack
  val logbackClassic = "ch.qos.logback" % "logback-classic" % Version.logBack
  val finatraHttp = twit %% "finatra-http" % Version.finatra exclude("com.twitter", "twitter-server")
  val guiceTestLib = "com.google.inject.extensions" % "guice-testlib" % Version.guice
  val injectCore = twit %% "inject-core" % Version.finatra
  val injectModules = twit %% "inject-modules" % Version.finatra
  val injectApp = twit %% "inject-app" % Version.finatra
  val injectServer = twit %% "inject-server" % Version.finatra exclude("com.twitter", "twitter-server")
}

object Dependencies {
  import Library._

  val client = List(
    gmFabricCore,
    junit,
    mockito
  )

  val model = List(
    scrooge,
    finagleThrift,
    utilCore,
    injectCore,
    injectApp
  )

  val server = List(
    gmFabricCore,
    finagleCore,
    finagleStats,
    utilCore,
    finagleThrift,
    serverSets,
    slf4jApi,
    logbackCore,
    logbackClassic,
    junit,
    twitterServer,
    finatraHttp,
    mockito,
    guiceTestLib,
    injectCore,
    injectModules,
    injectApp,
    injectServer
  )
}
