package io.github.g00fy2.content

import androidx.compose.runtime.Composable
import io.github.g00fy2.components.CardDark
import io.github.g00fy2.components.ContainerInSection
import io.github.g00fy2.components.LinkOnCard
import io.github.g00fy2.style.WtCols
import io.github.g00fy2.style.WtOffset
import io.github.g00fy2.style.WtRows
import io.github.g00fy2.style.WtSections
import io.github.g00fy2.style.WtText
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

private data class GetStartedCardPresentation(
  val title: String,
  val content: String,
  val links: List<LinkOnCard>
)

private fun getCards(): List<GetStartedCardPresentation> {
  return listOf(
    GetStartedCardPresentation(
      title = "Start tutorial here",
      content = "In this tutorial we will see how to create our first web UI application using Compose for Web.",
      links = listOf(
        LinkOnCard(
          linkText = "View tutorial",
          linkUrl = "https://github.com/JetBrains/compose-jb/tree/master/tutorials/Web/Getting_Started"
        )
      )
    ),
    GetStartedCardPresentation(
      title = "Landing page example",
      content = "An example of a landing page built using the Composable DOM API and Stylesheet DSL.",
      links = listOf(
        LinkOnCard(
          linkText = "Explore the source code",
          linkUrl = "https://github.com/JetBrains/compose-jb/tree/master/examples/web-landing"
        )
      )
    ),
    GetStartedCardPresentation(
      title = "Falling Balls app example",
      content = "This example demonstrates the use of multiplatform widgets – sharing user interface code between " +
        "Compose for Desktop and Web.",
      links = listOf(
        LinkOnCard(
          linkText = "Explore the source code",
          linkUrl = "https://github.com/JetBrains/compose-jb/tree/master/examples/falling-balls-web"
        ),
        LinkOnCard(
          linkText = "Play",
          linkUrl = "https://falling-balls.ui.pages.jetbrains.team/"
        )
      )
    )
  )
}

@Composable
private fun CardContent(text: String) {
  P(attrs = {
    classes(WtText.wtText2, WtText.wtText2ThemeDark, WtOffset.wtTopOffset24)
  }) {
    Text(text)
  }
}

@Composable
fun GetStarted() {
  ContainerInSection(WtSections.wtSectionBgGrayDark) {
    H1(attrs = {
      classes(WtText.wtH2, WtText.wtH2ThemeDark)
    }) {
      Text("Try out the Compose for Web")
    }

    Div(attrs = {
      classes(WtRows.wtRowSizeM, WtRows.wtRow, WtOffset.wtTopOffset24)
    }) {
      Div(attrs = {
        classes(WtCols.wtCol6, WtCols.wtColMd10, WtCols.wtColSm12, WtOffset.wtTopOffset24)
      }) {
        P(attrs = {
          classes(WtText.wtText1)
          style {
            color(Color("#fff"))
          }
        }) {
          Text("Ready for your next adventure? Learn how to build reactive user interfaces with Compose for Web.")
        }
      }
    }

    Div(
      attrs = {
        classes(WtRows.wtRow, WtRows.wtRowSizeM, WtOffset.wtTopOffset24)
      }
    ) {
      getCards().forEach {
        CardDark(
          title = it.title,
          link = "",
          wtExtraStyleClasses = listOf(WtCols.wtCol4, WtCols.wtColMd6, WtCols.wtColSm12)
        ) {
          CardContent(it.content)
        }
      }
    }
  }
}