package io.github.g00fy2.model.entities

external interface GitHubUser {
  val login: String
  val id: Int
  val node_id: String
  val avatar_url: String
  val gravatar_id: String
  val url: String
  val html_url: String
  val followers_url: String
  val following_url: String
  val gists_url: String
  val starred_url: String
  val subscriptions_url: String
  val organizations_url: String
  val repos_url: String
  val events_url: String
  val received_events_url: String
  val type: String
  val site_admin: Boolean
  val name: String
  val company: String
  val blog: String
  val location: String
  val email: String
  val hireable: Boolean
  val bio: String
  val twitter_username: String
  val public_repos: Int
  val public_gists: Int
  val followers: Int
  val following: Int
  val created_at: String
  val updated_at: String
}

data class KotlinGitHubUser(
  override val login: String,
  override val id: Int,
  override val node_id: String,
  override val avatar_url: String,
  override val gravatar_id: String,
  override val url: String,
  override val html_url: String,
  override val followers_url: String,
  override val following_url: String,
  override val gists_url: String,
  override val starred_url: String,
  override val subscriptions_url: String,
  override val organizations_url: String,
  override val repos_url: String,
  override val events_url: String,
  override val received_events_url: String,
  override val type: String,
  override val site_admin: Boolean,
  override val name: String,
  override val company: String,
  override val blog: String,
  override val location: String,
  override val email: String,
  override val hireable: Boolean,
  override val bio: String,
  override val twitter_username: String,
  override val public_repos: Int,
  override val public_gists: Int,
  override val followers: Int,
  override val following: Int,
  override val created_at: String,
  override val updated_at: String
) : GitHubUser