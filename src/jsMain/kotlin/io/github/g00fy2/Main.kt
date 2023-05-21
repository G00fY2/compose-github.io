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
import io.github.g00fy2.model.entities.GitHubLanguage
import io.github.g00fy2.model.entities.GitHubRepo
import io.github.g00fy2.model.entities.GitHubUser
import io.github.g00fy2.model.local.loadGitHubLanguages
import io.github.g00fy2.model.remote.fetchGitHubUser
import io.github.g00fy2.model.remote.fetchTopGitHubRepos
import io.github.g00fy2.style.AppStylesheet
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable

fun main() {
  renderComposable(rootElementId = "root") {
    Style(AppStylesheet)

    var githubUser by remember<MutableState<GitHubUser?>> { mutableStateOf(null) }
    var githubRepos by remember { mutableStateOf(emptyList<GitHubRepo>()) }
    var githubLanguageColors by remember { mutableStateOf(emptyList<GitHubLanguage>()) }

    LaunchedEffect(Unit) {
      fetchGitHubUser(BuildConfig.GITHUB_USER)
        .onSuccess { githubUser = it }
        .onFailure { it.printStackTrace() }
      fetchTopGitHubRepos(BuildConfig.GITHUB_USER)
        .onSuccess { githubRepos = it }
        .onFailure { it.printStackTrace() }
      loadGitHubLanguages()
        .onSuccess { githubLanguageColors = it }
        .onFailure { it.printStackTrace() }
    }

    Layout {
      Header(githubUser)
      MainContentLayout {
        Intro(githubUser)
        GithubRepos(githubRepos, githubLanguageColors)
        GetStarted()
        JoinUs()
      }
      PageFooter()
    }
  }
}