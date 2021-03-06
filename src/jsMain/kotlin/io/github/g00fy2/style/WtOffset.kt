package io.github.g00fy2.style

import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.media
import org.jetbrains.compose.web.css.mediaMaxWidth
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.value

object WtOffset : StyleSheet(AppStylesheet) {
  val wtTopOffset96 by style {
    marginTop(96.px)
    property(
      "margin-top",
      "calc(4*${AppCSSVariables.wtOffsetTopUnit.value(24.px)})"
    )
  }

  val wtTopOffset24 by style {
    marginTop(24.px)
    property(
      "margin-top",
      "calc(1*${AppCSSVariables.wtOffsetTopUnit.value(24.px)})"
    )
  }

  val wtTopOffset48 by style {
    marginTop(48.px)
  }

  val wtTopOffsetSm12 by style {
    media(mediaMaxWidth(640.px)) {
      self style {
        marginTop(12.px)
      }
    }
  }
}