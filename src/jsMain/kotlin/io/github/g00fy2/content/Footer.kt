package io.github.g00fy2.content

import androidx.compose.runtime.Composable
import io.github.g00fy2.style.WtCols
import io.github.g00fy2.style.WtContainers
import io.github.g00fy2.style.WtOffset
import io.github.g00fy2.style.WtRows
import io.github.g00fy2.style.WtSections
import io.github.g00fy2.style.WtText
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.boxSizing
import org.jetbrains.compose.web.css.flexShrink
import org.jetbrains.compose.web.css.flexWrap
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Footer
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun PageFooter() {
  Footer({
    style {
      flexShrink(0)
      boxSizing("border-box")
    }
  }) {
    Section({
      classes(WtSections.wtSectionBgGrayDark)
      style {
        padding(24.px, 0.px)
      }
    }) {
      Div({ classes(WtContainers.wtContainer) }) {
        Div({
          classes(WtRows.wtRow, WtRows.wtRowSizeM, WtRows.wtRowSmAlignItemsCenter)
          style {
            justifyContent(JustifyContent.Center)
            flexWrap(FlexWrap.Wrap)
          }
        }) {
          Div({
            classes(WtCols.wtColInline)
          }) {
            P({
              classes(WtText.wtText1, WtText.wtText1ThemeDark)
            }) {
              Text("Follow us")
            }
          }

          Div({
            classes(WtCols.wtColInline)
          }) {
            getSocialLinks().forEach { SocialIconLink(it) }
          }
        }

        CopyrightInFooter()
      }
    }
  }
}

@Composable
private fun CopyrightInFooter() {
  Div({
    classes(WtRows.wtRow, WtRows.wtRowSizeM, WtRows.wtRowSmAlignItemsCenter, WtOffset.wtTopOffset48)
    style {
      justifyContent(JustifyContent.SpaceEvenly)
      flexWrap(FlexWrap.Wrap)
      padding(0.px, 12.px)
    }
  }) {
    Span({
      classes(WtText.wtText3, WtText.wtTextPale)
    }) {
      Text("Copyright © 2021")
    }

    Span({
      classes(WtText.wtText3, WtText.wtTextPale)
    }) {
      Text("Developed with IntelliJ IDEA")
    }
  }
}

@Composable
private fun SocialIconLink(link: SocialLink) {
  A(attrs = {
    classes(WtText.wtSocialButtonItem)
    target(ATarget.Blank)
  }, href = link.url) {
    Img(src = link.iconSvg) {}
  }
}

private data class SocialLink(
  val id: String,
  val url: String,
  val title: String,
  val iconSvg: String
)

private fun getSocialLinks(): List<SocialLink> {
  return listOf(
    SocialLink("twitter", "https://twitter.com/jetbrains", "JetBrains on Twitter", "ic_twitter.svg"),
    SocialLink(
      "linkedin",
      "https://www.linkedin.com/company/jetbrains",
      "JetBrains on Linkedin",
      "ic_linkedin.svg"
    ),
  )
}