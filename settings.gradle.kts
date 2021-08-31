rootProject.name = "compose-github.io"

dependencyResolutionManagement {
  repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
  }
}

pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  }
}