package io.github.g00fy2.components

import androidx.compose.runtime.Composable
import io.github.g00fy2.style.WtCards
import io.github.g00fy2.style.WtCols
import io.github.g00fy2.style.WtOffset
import io.github.g00fy2.style.WtText
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Text

@Composable
private fun CardTitle(title: String, link: String) {
  A(href = link, attrs = {
    target(ATarget.Blank)
    classes(WtText.wtLink)
  }) {
    H3({
      classes(if (link.isEmpty()) WtText.wtH3ThemeDark else WtText.wtH3)
    }) {
      Text(title)
    }
  }
}

@Composable
fun Card(
  title: String,
  link: String,
  darkTheme: Boolean = false,
  wtExtraStyleClasses: List<String> = listOf(WtCols.wtCol6, WtCols.wtColMd6, WtCols.wtColSm12),
  content: @Composable () -> Unit
) {
  Div({
    classes(WtCards.wtCard, WtOffset.wtTopOffset24, *wtExtraStyleClasses.toTypedArray())
    classes(if (darkTheme) WtCards.wtCardThemeDark else WtCards.wtCardThemeLight)
  }) {
    Div({
      classes(WtCards.wtCardSection, WtCards.wtVerticalFlex)
    }) {

      Div({ classes(WtCards.wtVerticalFlexGrow) }) {
        CardTitle(title = title, link = link)
        content()
      }
    }
  }
}

@Composable
fun CardDark(
  title: String,
  link: String,
  wtExtraStyleClasses: List<String> = listOf(WtCols.wtCol6, WtCols.wtColMd6, WtCols.wtColSm12),
  content: @Composable () -> Unit
) {
  Card(
    title = title,
    link = link,
    darkTheme = true,
    wtExtraStyleClasses = wtExtraStyleClasses,
    content = content
  )
}

data class LinkOnCard(val linkText: String, val linkUrl: String)