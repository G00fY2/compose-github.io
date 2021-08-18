import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("multiplatform") version "1.5.21"
  id("org.jetbrains.compose") version "1.0.0-alpha4-build315"
  id("io.gitlab.arturbosch.detekt") version "1.18.0"
}

kotlin {
  js(IR) {
    browser()
    binaries.executable()
  }
  sourceSets {
    val jsMain by getting {
      dependencies {
        implementation(compose.web.core)
        implementation(compose.runtime)
      }
    }
  }
}

// kotlin compiler options
tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions {
    allWarningsAsErrors = true
    freeCompilerArgs = freeCompilerArgs + "-progressive"
  }
}

// explicitly set the webpack-dev-server version
extensions.configure<NodeJsRootExtension> {
  versions.webpackDevServer.version = "4.0.0"
}

// configure detekt
extensions.configure<DetektExtension> {
  toolVersion = "1.18.0"
  config = files("$rootDir/detekt.yml")
  buildUponDefaultConfig = true
}
dependencies {
  "detektPlugins"("io.gitlab.arturbosch.detekt:detekt-formatting:1.18.0")
}