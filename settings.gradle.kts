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
  resolutionStrategy {
    eachPlugin {
      if (requested.id.id == "com.codingfeline.buildkonfig") useModule("com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:${requested.version}")
    }
  }
}