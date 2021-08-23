package io.github.g00fy2

import io.github.g00fy2.components.Layout
import io.github.g00fy2.components.MainContentLayout
import io.github.g00fy2.content.ComposeWebLibraries
import io.github.g00fy2.content.GetStarted
import io.github.g00fy2.content.Header
import io.github.g00fy2.content.Intro
import io.github.g00fy2.content.JoinUs
import io.github.g00fy2.content.PageFooter
import io.github.g00fy2.model.entities.GitHubRepo
import io.github.g00fy2.model.entities.GitHubUser
import io.github.g00fy2.style.AppStylesheet
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable
import org.w3c.fetch.Headers
import org.w3c.fetch.RequestInit

fun main() {
  MainScope().launch {
    val user = fetchGitHubUser("G00fY2")
    console.log(JSON.stringify(user))

    val repos = fetchGitHubRepos("G00fY2")
    val topRepos = repos.sortedByDescending { it.stargazers_count }
      .filterNot { it.archived }
      .take(10)
      .map { it.full_name }
    console.log("top projects: $topRepos")
  }

  renderComposable(rootElementId = "root") {
    Style(AppStylesheet)

    Layout {
      Header()
      MainContentLayout {
        Intro()
        ComposeWebLibraries()
        GetStarted()
        JoinUs()
      }
      PageFooter()
    }
  }
}

const val GITHUB_API_URL = "https://api.github.com"
const val GITHUB_API_VERSION = 3

suspend fun fetchGitHubUser(username: String): GitHubUser {
  val headers = Headers().apply { append("Accept", "application/vnd.github.v$GITHUB_API_VERSION+json") }
  val response = window
    .fetch("$GITHUB_API_URL/users/$username", RequestInit(headers = headers))
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
suspend fun fetchGitHubRepos(username: String): Array<GitHubRepo> {
  val headers = Headers().apply { append("Accept", "application/vnd.github.v$GITHUB_API_VERSION+json") }
  val response = window
    .fetch("$GITHUB_API_URL/users/$username/repos?sort=updated&per_page=100", RequestInit(headers = headers))
    .await()
    .json()
    .await()
  return response.unsafeCast<Array<GitHubRepo>>()
}