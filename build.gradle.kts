import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension

plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.composeCompiler)
  alias(libs.plugins.jetbrainsCompose)
  alias(libs.plugins.buildconfig)
  alias(libs.plugins.detekt)
}

kotlin {
  compilerOptions {
    progressiveMode = true
    extraWarnings = true
  }
  js(IR) {
    browser()
    binaries.executable()
  }
  sourceSets {
    val jsMain by getting {
      dependencies {
        implementation(compose.html.core)
        implementation(compose.runtime)
        implementation(libs.coroutines.core.js)
      }
    }
  }
}

buildConfig {
  packageName("io.github.g00fy2")
  buildConfigField("String", "GITHUB_USER", "\"G00fY2\"")
  buildConfigField("String", "GITHUB_API_URL", "\"https://api.github.com\"")
  buildConfigField("String", "GITHUB_API_VERSION", "\"2022-11-28\"")
  // to increase rate limit add composeGitHubAuth with 'user:token' as base64 in local properties
  buildConfigField("String", "GITHUB_API_DEV_AUTH", findProperty("composeGitHubAuth") as String? ?: "\"\"")
}

// explicitly set the webpack-dev-server version
extensions.configure<NodeJsRootExtension> {
  versions.webpackDevServer.version = libs.versions.webpackDevServer.get()
  versions.webpackCli.version = libs.versions.webpackCli.get()
}

// configure detekt
extensions.configure<DetektExtension> {
  toolVersion = libs.versions.detekt.get()
  config.setFrom(files("$rootDir/detekt.yml"))
  buildUponDefaultConfig = true
}
dependencies {
  add("detektPlugins", rootProject.libs.detektFormatting)
}