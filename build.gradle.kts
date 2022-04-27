import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
  kotlin("multiplatform") version "1.6.21"
  id("org.jetbrains.compose") version "1.2.0-alpha01-dev675"
  id("com.github.gmazzo.buildconfig") version "3.0.3"
  id("io.gitlab.arturbosch.detekt") version "1.20.0"
  id("com.github.ben-manes.versions") version "0.42.0"
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
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
      }
    }
  }
}

buildConfig {
  packageName("io.github.g00fy2")
  buildConfigField("String", "GITHUB_USER", "\"G00fY2\"")
  buildConfigField("String", "GITHUB_API_URL", "\"https://api.github.com\"")
  buildConfigField("String", "GITHUB_API_VERSION", "\"3\"")
  // to increase rate limit add composeGitHubAuth with 'user:token' as base64 in local properties
  buildConfigField("String", "GITHUB_API_DEV_AUTH", findProperty("composeGitHubAuth") as String? ?: "\"\"")
}

// kotlin compiler options
tasks.withType<Kotlin2JsCompile>().configureEach {
  kotlinOptions {
    freeCompilerArgs = freeCompilerArgs + "-progressive"
  }
}

// explicitly set the webpack-dev-server version
extensions.configure<NodeJsRootExtension> {
  versions.webpackDevServer.version = "4.8.1"
  versions.webpackCli.version = "4.9.2"
}

// configure detekt
extensions.configure<DetektExtension> {
  toolVersion = "1.20.0"
  config = files("$rootDir/detekt.yml")
  buildUponDefaultConfig = true
}
dependencies {
  "detektPlugins"("io.gitlab.arturbosch.detekt:detekt-formatting:1.20.0")
}

// configure dependency updates
tasks.dependencyUpdates.configure {
  gradleReleaseChannel = "current"
  rejectVersionIf { releaseType(candidate.version) < releaseType(currentVersion) }
}

fun releaseType(version: String): Int {
  val sortedReleaseQualifiers = listOf("alpha", "beta", "m", "rc")
  val index = sortedReleaseQualifiers.indexOfFirst {
    version.matches(".*[.\\-]$it[.\\-\\d]*.*".toRegex(RegexOption.IGNORE_CASE))
  }
  return if (index < 0) sortedReleaseQualifiers.size else index
}