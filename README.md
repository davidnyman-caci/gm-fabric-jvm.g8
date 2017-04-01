A [Giter8][g8] template for ...!

# GM-Fabric-JVM G8

## Prerequisites

- [SBT][sbt]

- a locally installed version of [GM Fabric JVM][gmf] (until it is published)

- a way to build rpms, if you want to package it that way

[Giter8 Docs][docs] contain instructions for installing giter8

## To Create A Template

```
$ sbt new https://github.com/jeffusan/gm-fabric-jvm.g8.git
```

## Quick Start

To run a freshly minted gm-fabric-jvm app:

First compile it:

```
$> sbt stage
```

The run it locally:

```
$> ./server/target/universal/stage/bin/myapp-server
```

## Template Development

To test development of this plugin:

```
sbt g8Test
```

To create a template locally:

```
g8 file://gm-fabric-jvm.g8/ --name=uftest --force
```

[gmf]: https://github.com/DecipherNow/gm-fabric-jvm
[sbt]: http://www.scala-sbt.org/
[g8]: http://www.foundweekends.org/giter8/
[docs]: http://www.foundweekends.org/giter8/setup.html
