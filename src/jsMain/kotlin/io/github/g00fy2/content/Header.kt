package io.github.g00fy2.content

import androidx.compose.runtime.Composable
import io.github.g00fy2.style.AppStylesheet
import io.github.g00fy2.style.WtCols
import io.github.g00fy2.style.WtContainers
import io.github.g00fy2.style.WtRows
import io.github.g00fy2.style.WtSections
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Section

@Composable
fun Header() {
  Section(attrs = {
    classes(WtSections.wtSectionBgGrayDark)
  }) {
    Div({ classes(WtContainers.wtContainer) }) {
      Div({
        classes(WtRows.wtRow, WtRows.wtRowSizeM)
      }) {
        Logo()
      }
    }
  }
}

@Composable
private fun Logo() {
  Div(attrs = {
    classes(WtCols.wtColInline)
  }) {
    A(attrs = {
      target(ATarget.Blank)
    }, href = "https://www.jetbrains.com/") {
      Img(src = "i1.svg", attrs = { classes(AppStylesheet.headerLogo) })
    }
  }
}