package io.github.g00fy2.local

import io.github.g00fy2.model.entities.GitHubLanguage
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun loadGitHubLanguages(): List<GitHubLanguage> {
  return suspendCoroutine { continuation ->
    val list = js("require('./language_colors.json')").unsafeCast<Array<GitHubLanguage>>().toList()
    continuation.resume(list)
  }
}