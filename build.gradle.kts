import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.compose)
  alias(libs.plugins.buildconfig)
  alias(libs.plugins.detekt)
  alias(libs.plugins.gradleVersions)
}

kotlin {
  js(IR) {
    browser()
    binaries.executable()
  }
  sourceSets {
    val jsMain by getting {
      dependencies {
        implementation(compose.html.core)
        implementation(compose.runtime)
        implementation(libs.coroutines.core)
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
  versions.webpackDevServer.version = libs.versions.webpackDevServer.get()
  versions.webpackCli.version = libs.versions.webpackCli.get()
}

// configure detekt
extensions.configure<DetektExtension> {
  toolVersion = libs.versions.detekt.get()
  config = files("$rootDir/detekt.yml")
  buildUponDefaultConfig = true
}
dependencies {
  add("detektPlugins", rootProject.libs.detektFormatting)
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