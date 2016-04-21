enablePlugins(org.nlogo.build.NetLogoExtension)

netLogoExtName      := "hello-java"

netLogoClassManager := "HelloJavaExtension"

javaSource in Compile := baseDirectory.value / "src"

javacOptions ++= Seq("-deprecation")

netLogoVersion := "6.0.0-M5"

fork in run := true
