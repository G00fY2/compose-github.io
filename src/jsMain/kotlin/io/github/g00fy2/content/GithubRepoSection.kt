package io.github.g00fy2.content

import androidx.compose.runtime.Composable
import io.github.g00fy2.components.Card
import io.github.g00fy2.components.ContainerInSection
import io.github.g00fy2.components.LinkOnCard
import io.github.g00fy2.model.entities.GitHubRepo
import io.github.g00fy2.style.WtCols
import io.github.g00fy2.style.WtOffset
import io.github.g00fy2.style.WtRows
import io.github.g00fy2.style.WtSections
import io.github.g00fy2.style.WtText
import org.jetbrains.compose.web.css.paddingTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

@Composable
fun GithubRepos(githubRepos: List<GitHubRepo>) {
  ContainerInSection(WtSections.wtSectionBgGrayLight) {
    H2(attrs = { classes(WtText.wtH2) }) {
      Text("Building user interfaces with Compose for Web")
    }

    Div(attrs = {
      classes(WtRows.wtRow, WtRows.wtRowSizeM)
    }) {
      Div(attrs = {
        classes(WtCols.wtCol6, WtCols.wtColMd6, WtCols.wtColSm12, WtOffset.wtTopOffset24)
      }) {
        P(attrs = {
          classes(WtText.wtText1)
        }) {
          Text("Compose for Web allows you to build reactive user interfaces for the web in Kotlin, using the " +
            "concepts and APIs of Jetpack Compose to express the state, behavior, and logic of your application.")
        }
      }

      Div(attrs = {
        classes(WtCols.wtCol6, WtCols.wtColMd6, WtCols.wtColSm12, WtOffset.wtTopOffset24)
      }) {
        P(attrs = {
          classes(WtText.wtText1)
        }) {
          Text("Compose for Web provides multiple ways of declaring user interfaces in Kotlin code, allowing you " +
            "to have full control over your website layout with a declarative DOM API, or use versions of the " +
            "widgets you already know from Jetpack Compose for Desktop and Android.\n")
        }
      }
    }

    Div(attrs = {
      classes(WtRows.wtRow, WtRows.wtRowSizeM, WtOffset.wtTopOffset48)
    }) {
      githubRepos.map {
        CardWithListPresentation(title = it.full_name, list = it.description.split("."))
      }.forEach { CardWithList(it) }
    }
  }
}

@Composable
private fun CardWithList(card: CardWithListPresentation) {
  Card(
    title = card.title,
    links = card.links
  ) {
    Ul(attrs = {
      classes(WtText.wtText2)
    }) {
      card.list.forEachIndexed { _, it ->
        Li({
          style {
            paddingTop(24.px)
          }
        }) { Text(it) }
      }
    }
  }
}

data class CardWithListPresentation(
  val title: String,
  val list: List<String>,
  val links: List<LinkOnCard> = emptyList()
)