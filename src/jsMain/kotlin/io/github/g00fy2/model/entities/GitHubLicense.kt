package io.github.g00fy2.model.entities

@Suppress("PropertyName")
external interface GitHubLicense {
  val key: String
  val name: String
  val spdx_id: String
  val url: String
  val node_id: String
}