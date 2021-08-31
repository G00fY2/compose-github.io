import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
  kotlin("multiplatform") version "1.5.30"
  id("org.jetbrains.compose") version "1.0.0-alpha4-build328"
  id("com.codingfeline.buildkonfig") version "0.9.0"
  id("io.gitlab.arturbosch.detekt") version "1.18.1"
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
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
      }
    }
  }
}

buildkonfig {
  packageName = "io.github.g00fy2"
  defaultConfigs { }
  targetConfigs {
    create("js") {
      buildConfigField(STRING, "githubUser", "G00fY2")
      buildConfigField(STRING, "githubApiUrl", "https://api.github.com")
      buildConfigField(STRING, "githubApiVersion", "3")
    }
  }
}

// kotlin compiler options
tasks.withType<Kotlin2JsCompile>().configureEach {
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
  toolVersion = "1.18.1"
  config = files("$rootDir/detekt.yml")
  buildUponDefaultConfig = true
}
dependencies {
  "detektPlugins"("io.gitlab.arturbosch.detekt:detekt-formatting:1.18.1")
}