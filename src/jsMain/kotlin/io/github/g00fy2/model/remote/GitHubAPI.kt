package io.github.g00fy2.model.remote

import io.github.g00fy2.BuildConfig
import io.github.g00fy2.model.entities.GitHubRepo
import io.github.g00fy2.model.entities.GitHubUser
import io.github.g00fy2.model.entities.GitSearchResult
import kotlinx.browser.window
import kotlinx.coroutines.await
import org.w3c.fetch.DEFAULT
import org.w3c.fetch.Headers
import org.w3c.fetch.RequestCache
import org.w3c.fetch.RequestInit

const val PROJECT_COUNT = 6

private fun getHeaders(): Headers {
  return Headers().apply {
    append("X-GitHub-Api-Version", BuildConfig.GITHUB_API_VERSION)
    if (BuildConfig.GITHUB_API_DEV_AUTH.isNotEmpty()) {
      append("Authorization", "Basic ${BuildConfig.GITHUB_API_DEV_AUTH}")
    }
  }
}

suspend fun fetchGitHubUser(username: String): Result<GitHubUser> {
  return runCatching {
    window
      .fetch(
        input = "${BuildConfig.GITHUB_API_URL}/users/$username",
        init = RequestInit(
          headers = getHeaders(),
          cache = RequestCache.DEFAULT,
        )
      )
      .await()
      .json()
      .await()
      .unsafeCast<GitHubUser>()
  }
}

suspend fun fetchTopGitHubRepos(username: String): Result<List<GitHubRepo>> {
  return runCatching {
    window
      .fetch(
        input = "${BuildConfig.GITHUB_API_URL}/search/repositories?q=user:$username&sort=stars&per_page=$PROJECT_COUNT",
        init = RequestInit(
          headers = getHeaders(),
          cache = RequestCache.DEFAULT,
        )
      )
      .await()
      .json()
      .await()
      .unsafeCast<GitSearchResult>()
      .items
      .toList()
  }
}