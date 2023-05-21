package io.github.g00fy2.model.local

import io.github.g00fy2.model.entities.GitHubLanguage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun loadGitHubLanguages(): Result<List<GitHubLanguage>> {
  return runCatching {
    withContext(Dispatchers.Default) {
      js("require('./language_colors.json')").unsafeCast<Array<GitHubLanguage>>().toList()
    }
  }
}