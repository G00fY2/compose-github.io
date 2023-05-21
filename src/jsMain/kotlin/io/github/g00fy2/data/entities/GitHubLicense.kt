@file:Suppress("VariableNaming", "PropertyName")

package io.github.g00fy2.data.entities

external interface GitHubLicense {
  val key: String
  val name: String
  val spdx_id: String
  val url: String
  val node_id: String
}