package io.github.g00fy2.model.entities

external interface GitHubRepo {
  val id: Long
  val node_id: String
  val name: String
  val full_name: String
  val private: Boolean
  val owner: GitHubOwner
  val html_url: String
  val description: String
  val fork: Boolean
  val url: String
  val forks_url: String
  val keys_url: String
  val collaborators_url: String
  val teams_url: String
  val hooks_url: String
  val issue_events_url: String
  val events_url: String
  val assignees_url: String
  val branches_url: String
  val tags_url: String
  val blobs_url: String
  val git_tags_url: String
  val git_refs_url: String
  val trees_url: String
  val statuses_url: String
  val languages_url: String
  val stargazers_url: String
  val contributors_url: String
  val subscribers_url: String
  val subscription_url: String
  val commits_url: String
  val git_commits_url: String
  val comments_url: String
  val issue_comment_url: String
  val contents_url: String
  val compare_url: String
  val merges_url: String
  val archive_url: String
  val downloads_url: String
  val issues_url: String
  val pulls_url: String
  val milestones_url: String
  val notifications_url: String
  val labels_url: String
  val releases_url: String
  val deployments_url: String
  val created_at: String
  val updated_at: String
  val pushed_at: String
  val git_url: String
  val ssh_url: String
  val clone_url: String
  val svn_url: String
  val homepage: String
  val size: Long
  val stargazers_count: Int
  val watchers_count: Int
  val language: String
  val has_issues: Boolean
  val has_projects: Boolean
  val has_downloads: Boolean
  val has_wiki: Boolean
  val has_pages: Boolean
  val forks_count: Int
  val mirror_url: String
  val archived: Boolean
  val disabled: Boolean
  val open_issues_count: Int
  val license: GitHubLicense
  val forks: Int
  val open_issues: Int
  val watchers: Int
  val default_branch: String
}

external interface GitHubOwner {
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
}

external interface GitHubLicense {
  val key: String
  val name: String
  val spdx_id: String
  val url: String
  val node_id: String
}

data class KotlinGitHubRepo(
  override val id: Long,
  override val node_id: String,
  override val name: String,
  override val full_name: String,
  override val private: Boolean,
  override val owner: KotlinGitHubOwner,
  override val html_url: String,
  override val description: String,
  override val fork: Boolean,
  override val url: String,
  override val forks_url: String,
  override val keys_url: String,
  override val collaborators_url: String,
  override val teams_url: String,
  override val hooks_url: String,
  override val issue_events_url: String,
  override val events_url: String,
  override val assignees_url: String,
  override val branches_url: String,
  override val tags_url: String,
  override val blobs_url: String,
  override val git_tags_url: String,
  override val git_refs_url: String,
  override val trees_url: String,
  override val statuses_url: String,
  override val languages_url: String,
  override val stargazers_url: String,
  override val contributors_url: String,
  override val subscribers_url: String,
  override val subscription_url: String,
  override val commits_url: String,
  override val git_commits_url: String,
  override val comments_url: String,
  override val issue_comment_url: String,
  override val contents_url: String,
  override val compare_url: String,
  override val merges_url: String,
  override val archive_url: String,
  override val downloads_url: String,
  override val issues_url: String,
  override val pulls_url: String,
  override val milestones_url: String,
  override val notifications_url: String,
  override val labels_url: String,
  override val releases_url: String,
  override val deployments_url: String,
  override val created_at: String,
  override val updated_at: String,
  override val pushed_at: String,
  override val git_url: String,
  override val ssh_url: String,
  override val clone_url: String,
  override val svn_url: String,
  override val homepage: String,
  override val size: Long,
  override val stargazers_count: Int,
  override val watchers_count: Int,
  override val language: String,
  override val has_issues: Boolean,
  override val has_projects: Boolean,
  override val has_downloads: Boolean,
  override val has_wiki: Boolean,
  override val has_pages: Boolean,
  override val forks_count: Int,
  override val mirror_url: String,
  override val archived: Boolean,
  override val disabled: Boolean,
  override val open_issues_count: Int,
  override val license: KotlinGitHubLicense,
  override val forks: Int,
  override val open_issues: Int,
  override val watchers: Int,
  override val default_branch: String
) : GitHubRepo

data class KotlinGitHubOwner(
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
  override val site_admin: Boolean
) : GitHubOwner

data class KotlinGitHubLicense(
  override val key: String,
  override val name: String,
  override val spdx_id: String,
  override val url: String,
  override val node_id: String
) : GitHubLicense