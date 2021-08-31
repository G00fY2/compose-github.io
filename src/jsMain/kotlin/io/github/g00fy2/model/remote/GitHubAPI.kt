package io.github.g00fy2.model.remote

import io.github.g00fy2.BuildConfig
import io.github.g00fy2.model.entities.GitHubRepo
import io.github.g00fy2.model.entities.GitHubUser
import kotlinx.browser.window
import kotlinx.coroutines.await
import org.w3c.fetch.Headers
import org.w3c.fetch.RequestInit

private fun getHeaders() =
  Headers().apply { append("Accept", "application/vnd.github.v${BuildConfig.GITHUB_API_VERSION}+json") }

suspend fun fetchGitHubUser(username: String): GitHubUser {
  val response = window
    .fetch("${BuildConfig.GITHUB_API_URL}/users/$username", RequestInit(headers = getHeaders()))
    .await()
    .json()
    .await()

  return response.unsafeCast<GitHubUser>()
}

/**
 * available query params
 * type: Can be one of all, owner (default), member
 * sort: Can be one of created, updated, pushed, full_name (default)
 * direction: Can be one of asc or desc. Default: asc when using full_name, otherwise desc
 * per_page: Results per page (max 100, default 30)
 * page: Page number of the results to fetch (default 1)
 */
suspend fun fetchTopGitHubRepos(username: String, filterArchived: Boolean = true, count: Int = 6): List<GitHubRepo> {
  val response = window
    .fetch(
      "${BuildConfig.GITHUB_API_URL}/users/$username/repos?sort=updated&per_page=100",
      RequestInit(headers = getHeaders())
    )
    .await()
    .json()
    .await()

  return response.unsafeCast<Array<GitHubRepo>>()
    .sortedByDescending { it.stargazers_count }
    .filterNot { it.archived && filterArchived }
    .take(count)
}