package io.github.g00fy2

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import io.github.g00fy2.components.Layout
import io.github.g00fy2.components.MainContentLayout
import io.github.g00fy2.content.GetStarted
import io.github.g00fy2.content.GithubRepos
import io.github.g00fy2.content.Header
import io.github.g00fy2.content.Intro
import io.github.g00fy2.content.JoinUs
import io.github.g00fy2.content.PageFooter
import io.github.g00fy2.model.entities.GitHubRepo
import io.github.g00fy2.model.entities.GitHubUser
import io.github.g00fy2.style.AppStylesheet
import kotlinx.browser.window
import kotlinx.coroutines.await
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable
import org.w3c.fetch.Headers
import org.w3c.fetch.RequestInit

fun main() {
  renderComposable(rootElementId = "root") {
    Style(AppStylesheet)

    var githubUser by remember<MutableState<GitHubUser?>> { mutableStateOf(null) }
    var githubRepos by remember { mutableStateOf(emptyList<GitHubRepo>()) }

    LaunchedEffect(true) {
      githubUser = fetchGitHubUser(BuildKonfig.githubUser)
      githubRepos = fetchTopGitHubRepos(BuildKonfig.githubUser)
    }

    Layout {
      Header()
      MainContentLayout {
        Intro(githubUser)
        GithubRepos(githubRepos)
        GetStarted()
        JoinUs()
      }
      PageFooter()
    }
  }
}

suspend fun fetchGitHubUser(username: String): GitHubUser {
  val headers = Headers().apply {
    append("Accept", "application/vnd.github.v${BuildKonfig.githubApiVersion}+json")
  }
  val response = window
    .fetch("${BuildKonfig.githubApiUrl}/users/$username", RequestInit(headers = headers))
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
suspend fun fetchTopGitHubRepos(username: String): List<GitHubRepo> {
  val headers = Headers().apply {
    append("Accept", "application/vnd.github.v${BuildKonfig.githubApiVersion}+json")
  }
  val response = window
    .fetch(
      "${BuildKonfig.githubApiUrl}/users/$username/repos?sort=updated&per_page=100",
      RequestInit(headers = headers)
    )
    .await()
    .json()
    .await()

  return response.unsafeCast<Array<GitHubRepo>>()
    .sortedByDescending { it.stargazers_count }
    .filterNot { it.archived }
    .take(6)
}