package io.github.g00fy2.content

import androidx.compose.runtime.Composable
import io.github.g00fy2.components.ContainerInSection
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
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.whiteSpace
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun Intro() {
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
        Img(src = "i1.svg", attrs = { classes(AppStylesheet.composeLogo) })
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
          Text("Compose for ")
          Span({
            classes(WtText.wtHero)
            style {
              display(DisplayStyle.InlineBlock)
              whiteSpace("nowrap")
            }
          }) {
            Text("Web")

            Span(attrs = { classes(AppStylesheet.composeTitleTag) }) {
              Text("Technology preview")
            }
          }
        }
        Div({
          classes(WtDisplay.wtDisplayMdNone)
        }) {
          IntroAboutComposeWeb()
        }
      }
    }

    Div(attrs = {
      classes(WtDisplay.wtDisplayNone, WtDisplay.wtDisplayMdBlock)
    }) {
      IntroAboutComposeWeb()
    }
  }
}

@Composable
private fun IntroAboutComposeWeb() {
  Div({
    classes(WtRows.wtRow, WtRows.wtRowSizeM)
  }) {

    Div({
      classes(WtCols.wtCol9, WtCols.wtColMd9, WtCols.wtColSm12)
    }) {
      P({ classes(WtText.wtSubtitle2, WtOffset.wtTopOffset24) }) {
        Text("Reactive web UIs for Kotlin, based on Google's ")

        A(href = "https://developer.android.com/jetpack/compose", attrs = {
          classes(WtText.wtLink)
          target(ATarget.Blank)
        }) {
          Text("modern toolkit")
        }

        Text(" and brought to you by JetBrains")
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

      ComposeWebStatusMessage()

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

@Composable
private fun ComposeWebStatusMessage() {
  Div({
    classes(WtRows.wtRow, WtRows.wtRowSizeXs, WtOffset.wtTopOffset24)
  }) {
    Div({
      classes(WtCols.wtColInline)
    }) {
      Img(src = "ic_info.svg", attrs = {
        style {
          width(24.px)
          height(24.px)
        }
      })
    }

    Div({
      classes(WtCols.wtColAutoFill)
    }) {
      P({
        classes(WtText.wtText3)
      }) {
        Text(
          "With its current status Technology Preview, Compose for Web " +
            "is not production-ready, and should only be used in experiments. " +
            "We are hard at work to bring you great learning materials, tutorials, " +
            "and documentation, and optimize the performance of Compose for Web in the future!"
        )
      }
    }
  }
}