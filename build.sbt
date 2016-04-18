enablePlugins(org.nlogo.build.NetLogoExtension)

netLogoExtName      := "hello-java"

netLogoClassManager := "HelloJavaExtension"

scalaVersion           := "2.11.7"

javaSource in Compile := baseDirectory.value / "src"

scalacOptions          ++= Seq("-deprecation", "-unchecked", "-Xfatal-warnings", "-encoding", "us-ascii")

netLogoVersion := "6.0.0-M4"

fork in run := true
