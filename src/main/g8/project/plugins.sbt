resolvers ++= Seq(
  Resolver.bintrayIvyRepo("lembrd", "sbt-plugins"),
  Resolver.bintrayRepo("twittercsl", "sbt-plugins")
)
addSbtPlugin("org.lembrd" % "tanuki-plugin" % "0.4")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.2.0-M8")
addSbtPlugin("com.twitter" % "scrooge-sbt-plugin" % "4.14.0")
