package io.github.g00fy2.content

import androidx.compose.runtime.Composable
import io.github.g00fy2.components.ContainerInSection
import io.github.g00fy2.style.WtCols
import io.github.g00fy2.style.WtOffset
import io.github.g00fy2.style.WtRows
import io.github.g00fy2.style.WtSections
import io.github.g00fy2.style.WtText
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun JoinUs() {
  ContainerInSection(WtSections.wtSectionBgGrayLight) {
    Div(attrs = {
      classes(WtRows.wtRow, WtRows.wtRowSizeM)
    }) {
      Div(attrs = {
        classes(WtCols.wtCol9, WtCols.wtColMd11, WtCols.wtColSm12)
      }) {

        P(attrs = {
          classes(WtText.wtSubtitle2)
        }) {
          Text("Interested in Compose for other platforms?")

          P {
            Text("Have a look at ")
            A(href = "https://www.jetbrains.com/lp/compose/", attrs = {
              classes(WtText.wtLink)
              target(ATarget.Blank)
            }) {
              Text("Compose for Desktop")
            }
          }
        }

        P(attrs = {
          classes(WtText.wtSubtitle2, WtOffset.wtTopOffset24)
        }) {
          Text("Feel free to join the ")
          LinkToSlack(
            url = "https://kotlinlang.slack.com/archives/C01F2HV7868",
            text = "#compose-web"
          )
          Text(" channel on Kotlin Slack to discuss Compose for Web, or ")
          LinkToSlack(
            url = "https://kotlinlang.slack.com/archives/CJLTWPH7S",
            text = "#compose"
          )
          Text(" for general Compose discussions")
        }
      }
    }

    A(attrs = {
      classes(WtText.wtButton, WtText.wtButtonContrast, WtOffset.wtTopOffset24)
      target(ATarget.Blank)
    }, href = "https://surveys.jetbrains.com/s3/kotlin-slack-sign-up") {
      Text("Join Kotlin Slack")
    }
  }
}

@Composable
private fun LinkToSlack(url: String, text: String) {
  A(href = url, attrs = {
    target(ATarget.Blank)
    classes(WtText.wtLink)
  }) {
    Text(text)
  }
}