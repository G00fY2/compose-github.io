package io.github.g00fy2.model.entities

@Suppress("PropertyName")
external interface GitSearchResult {
  val total_count: Int
  val incomplete_results: Boolean
  val items: Array<GitHubRepo>
}