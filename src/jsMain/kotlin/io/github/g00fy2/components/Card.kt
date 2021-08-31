package io.github.g00fy2.components

import androidx.compose.runtime.Composable
import io.github.g00fy2.style.WtCards
import io.github.g00fy2.style.WtCols
import io.github.g00fy2.style.WtOffset
import io.github.g00fy2.style.WtText
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Text

@Composable
private fun CardTitle(title: String, darkTheme: Boolean = false) {
  H3({
    classes(WtText.wtH3)
    if (darkTheme) {
      classes(WtText.wtH3ThemeDark)
    }
  }) {
    Text(title)
  }
}

@Composable
fun Card(
  title: String,
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
        CardTitle(title = title, darkTheme = darkTheme)
        content()
      }
    }
  }
}

@Composable
fun CardDark(
  title: String,
  wtExtraStyleClasses: List<String> = listOf(WtCols.wtCol6, WtCols.wtColMd6, WtCols.wtColSm12),
  content: @Composable () -> Unit
) {
  Card(
    title = title,
    darkTheme = true,
    wtExtraStyleClasses = wtExtraStyleClasses,
    content = content
  )
}

data class LinkOnCard(val linkText: String, val linkUrl: String)