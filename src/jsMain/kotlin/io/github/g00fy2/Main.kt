package io.github.g00fy2

import io.github.g00fy2.components.Layout
import io.github.g00fy2.components.MainContentLayout
import io.github.g00fy2.content.ComposeWebLibraries
import io.github.g00fy2.content.GetStarted
import io.github.g00fy2.content.Header
import io.github.g00fy2.content.Intro
import io.github.g00fy2.content.JoinUs
import io.github.g00fy2.content.PageFooter
import io.github.g00fy2.style.AppStylesheet
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable

fun main() {
  renderComposable(rootElementId = "root") {
    Style(AppStylesheet)

    Layout {
      Header()
      MainContentLayout {
        Intro()
        ComposeWebLibraries()
        GetStarted()
        JoinUs()
      }
      PageFooter()
    }
  }
}