@file:Suppress("VariableNaming", "PropertyName")

package io.github.g00fy2.data.entities

external interface GitSearchResult {
  val total_count: Int
  val incomplete_results: Boolean
  val items: Array<GitHubRepo>
}