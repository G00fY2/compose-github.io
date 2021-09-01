package io.github.g00fy2.content

import androidx.compose.runtime.Composable
import io.github.g00fy2.model.entities.GitHubUser
import io.github.g00fy2.style.AppStylesheet
import io.github.g00fy2.style.WtCols
import io.github.g00fy2.style.WtContainers
import io.github.g00fy2.style.WtRows
import io.github.g00fy2.style.WtSections
import io.github.g00fy2.style.WtText
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Text

@Composable
fun Header(githubUser: GitHubUser?) {
  Section(attrs = {
    classes(WtSections.wtSectionBgGrayDark)
  }) {
    Div({ classes(WtContainers.wtContainer) }) {
      Div({
        classes(WtRows.wtRow, WtRows.wtRowSizeM)
        style {
          justifyContent(JustifyContent.SpaceBetween)
        }
      }) {
        Avatar(githubUser?.avatar_url ?: "")
        GitHubButton()
      }
    }
  }
}

@Composable
private fun Avatar(imgUrl: String) {
  Div(attrs = {
    classes(WtCols.wtColInline)
  }) {
    A(attrs = {
      target(ATarget.Blank)
    }, href = "https://github.com/G00fY2") {
      Img(src = imgUrl, attrs = { classes(AppStylesheet.headerAvatar) })
    }
  }
}

@Composable
private fun GitHubButton() {
  Div(attrs = {
    classes(WtCols.wtColInline)
  }) {
    Button(attrs = {
      classes(WtText.wtButton, WtText.wtGitHubButton)
      onClick { window.open("https://github.com/G00fY2/compose-github.io") }
    }) {
      Img(src = "ic_github.svg", attrs = { classes(AppStylesheet.githubHeaderLogo) })
      Text("Open in GitHub")
    }
  }
}