package io.github.g00fy2.style

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSUnitValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.StylePropertyNumber
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.boxSizing
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.letterSpacing
import org.jetbrains.compose.web.css.lineHeight
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.css.marginRight
import org.jetbrains.compose.web.css.maxWidth
import org.jetbrains.compose.web.css.media
import org.jetbrains.compose.web.css.mediaMaxWidth
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.paddingRight
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.selectors.CSSSelector
import org.jetbrains.compose.web.css.top
import org.jetbrains.compose.web.css.value
import org.jetbrains.compose.web.css.variable

object AppCSSVariables {
  val wtColorGreyLight by variable<CSSColorValue>()
  val wtColorGreyDark by variable<CSSColorValue>()

  val wtOffsetTopUnit by variable<CSSUnitValue>()
  val wtHorizontalLayoutGutter by variable<CSSUnitValue>()
  val wtFlowUnit by variable<CSSUnitValue>()

  val wtHeroFontSize by variable<CSSUnitValue>()
  val wtHeroLineHeight by variable<CSSUnitValue>()
  val wtSubtitle2FontSize by variable<CSSUnitValue>()
  val wtSubtitle2LineHeight by variable<CSSUnitValue>()
  val wtH2FontSize by variable<CSSUnitValue>()
  val wtH2LineHeight by variable<CSSUnitValue>()
  val wtH3FontSize by variable<CSSUnitValue>()
  val wtH3LineHeight by variable<CSSUnitValue>()

  val wtColCount by variable<StylePropertyNumber>()
}

object AppStylesheet : StyleSheet() {
  val headerAvatar by style {
    borderRadius(50.percent)
    maxWidth(32.px)
  }

  val githubHeaderLogo by style {
    paddingRight(8.px)
    maxWidth(24.px)
  }

  val mainAvatar by style {
    borderRadius(50.percent)
    maxWidth(100.percent)
  }

  val composeTitleTag by style {
    padding(5.px, 12.px)
    letterSpacing("normal")
    fontWeight(400)
    lineHeight(24.px)

    position(Position.Relative)
    top((-32).px)
    marginLeft(8.px)
    fontSize(15.px)
    backgroundColor(rgba(39, 40, 44, .05))
    color(rgba(39, 40, 44, .7))
    borderRadius(4.px, 4.px, 4.px)

    media(mediaMaxWidth(640.px)) {
      self style {
        top((-16).px)
      }
    }
  }

  init {
    "label, a, button" style {
      property(
        "font-family",
        "system-ui,-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Oxygen,Ubuntu,Cantarell,Droid Sans," +
          "Helvetica Neue,Arial,sans-serif"
      )
    }

    CSSSelector.Universal style {
      AppCSSVariables.wtColorGreyLight(Color("#f4f4f4"))
      AppCSSVariables.wtColorGreyDark(Color("#323236"))
      AppCSSVariables.wtOffsetTopUnit(24.px)

      margin(0.px)
    }

    media(mediaMaxWidth(640.px)) {
      CSSSelector.Universal style {
        AppCSSVariables.wtOffsetTopUnit(16.px)
        AppCSSVariables.wtFlowUnit(16.px)
      }
    }

    CSSSelector.Attribute(
      name = "class",
      value = "wtCol",
      operator = CSSSelector.Attribute.Operator.Contains
    ) style {
      marginRight(AppCSSVariables.wtHorizontalLayoutGutter.value())
      marginLeft(AppCSSVariables.wtHorizontalLayoutGutter.value())

      property(
        "flex-basis",
        "calc(8.33333%*${AppCSSVariables.wtColCount.value()} - ${AppCSSVariables.wtHorizontalLayoutGutter.value()}*2)"
      )
      property(
        "max-width",
        "calc(8.33333%*${AppCSSVariables.wtColCount.value()} - ${AppCSSVariables.wtHorizontalLayoutGutter.value()}*2)"
      )
      boxSizing("border-box")
    }
  }
}