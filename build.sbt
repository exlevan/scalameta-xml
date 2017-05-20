inThisBuild(List(
  scalaVersion := "2.12.2"
))

lazy val macroSettings: List[Def.Setting[_]] = List(
  resolvers ++= List(
    Resolver.sonatypeRepo("snapshots"),
    Resolver.sonatypeRepo("releases"),
    Resolver.bintrayRepo("scalameta", "maven")
  ),
  libraryDependencies += compilerPlugin("org.scalameta" % "paradise" % "3.0.0-310-50622ade" cross CrossVersion.patch),
  scalacOptions += "-Xplugin-require:macroparadise"
)

lazy val macros =
  project
    .settings(
      macroSettings,
      libraryDependencies += "org.scalameta" %% "scalameta" % "1.8.0-664-e92a7b98"
    )

lazy val xml =
  project
    .settings(
      macroSettings,
      libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.6" % Provided
    )
    .dependsOn(macros)
