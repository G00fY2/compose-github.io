package io.github.g00fy2.model.local

import io.github.g00fy2.model.entities.GitHubLanguage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun loadGitHubLanguages(): List<GitHubLanguage> {
  return withContext(Dispatchers.Default) {
    js("require('./language_colors.json')").unsafeCast<Array<GitHubLanguage>>().toList()
  }
}