rootProject.name = "compose-github.io"

dependencyResolutionManagement {
  @Suppress("UnstableApiUsage")
  repositories {
    google {
      @Suppress("UnstableApiUsage")
      mavenContent {
        includeGroupAndSubgroups("androidx")
        includeGroupAndSubgroups("com.android")
        includeGroupAndSubgroups("com.google")
        includeGroupAndSubgroups("org.jetbrains")
      }
    }
    mavenCentral()
  }
}

pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
  }
}