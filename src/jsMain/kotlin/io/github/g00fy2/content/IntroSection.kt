package io.github.g00fy2.content

import androidx.compose.runtime.Composable
import io.github.g00fy2.components.ContainerInSection
import io.github.g00fy2.model.entities.GitHubUser
import io.github.g00fy2.style.AppStylesheet
import io.github.g00fy2.style.WtCols
import io.github.g00fy2.style.WtDisplay
import io.github.g00fy2.style.WtOffset
import io.github.g00fy2.style.WtRows
import io.github.g00fy2.style.WtText
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.alignSelf
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.whiteSpace
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun Intro(githubUser: GitHubUser?) {
  ContainerInSection {
    Div({
      classes(WtRows.wtRow, WtRows.wtRowSizeM, WtRows.wtRowSmAlignItemsCenter)
    }) {

      Div({
        classes(WtCols.wtCol2, WtCols.wtColMd3)
        style {
          alignSelf(AlignSelf.Start)
        }
      }) {
        Img(src = githubUser?.avatar_url ?: "", attrs = {
          classes(AppStylesheet.composeLogo)
          style {
            borderRadius(50.percent)
          }
        })
      }

      Div({
        classes(
          WtCols.wtCol10,
          WtCols.wtColMd8,
          WtCols.wtColSm12,
          WtOffset.wtTopOffsetSm12
        )
      }) {
        H1(attrs = { classes(WtText.wtHero) }) {
          Text(githubUser?.name ?: "")
          Span({
            classes(WtText.wtHero)
            style {
              display(DisplayStyle.InlineBlock)
              whiteSpace("nowrap")
            }
          }) {
            Span(attrs = { classes(AppStylesheet.composeTitleTag) }) {
              Text(githubUser?.login ?: "")
            }
          }
        }
        Div({
          classes(WtDisplay.wtDisplayMdNone)
        }) {
          IntroAboutComposeWeb(githubUser)
        }
      }
    }

    Div(attrs = {
      classes(WtDisplay.wtDisplayNone, WtDisplay.wtDisplayMdBlock)
    }) {
      IntroAboutComposeWeb(githubUser)
    }
  }
}

@Composable
private fun IntroAboutComposeWeb(githubUser: GitHubUser?) {
  Div({
    classes(WtRows.wtRow, WtRows.wtRowSizeM)
  }) {

    Div({
      classes(WtCols.wtCol9, WtCols.wtColMd9, WtCols.wtColSm12)
    }) {
      P({ classes(WtText.wtSubtitle2, WtOffset.wtTopOffset24) }) {
        Text(githubUser?.bio ?: "")
      }

      P({
        classes(WtText.wtText1, WtOffset.wtTopOffset24)
      }) {
        Text(
          "Compose for Web simplifies and accelerates UI development for web applications, " +
            "and aims to enable UI code sharing between web, desktop, and Android applications " +
            "in the future. Currently in technology preview."
        )
      }

      A(
        attrs = {
          classes(WtText.wtButton, WtOffset.wtTopOffset24)
          target(ATarget.Blank)
        },
        href = "https://github.com/jetbrains/compose-jb"
      ) {
        Text("Explore on GitHub")
      }
    }
  }
}