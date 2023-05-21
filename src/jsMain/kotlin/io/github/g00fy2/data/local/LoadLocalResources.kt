package io.github.g00fy2.data.local

import io.github.g00fy2.data.entities.GitHubLanguage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun loadGitHubLanguages(): Result<List<GitHubLanguage>> {
  return runCatching {
    withContext(Dispatchers.Default) {
      js("require('./language_colors.json')").unsafeCast<Array<GitHubLanguage>>().toList()
    }
  }
}