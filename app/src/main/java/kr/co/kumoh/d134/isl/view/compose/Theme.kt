package kr.co.kumoh.d134.isl.view.compose

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import kr.co.kumoh.d134.isl.R

val Notofonts = FontFamily(
    Font(R.font.noto_kr_bold, weight = FontWeight.Bold),
    Font(R.font.noto_kr_black, weight = FontWeight.Black),
    Font(R.font.noto_kr_medium, weight = FontWeight.Medium),
    Font(R.font.noto_kr_light, weight = FontWeight.Light)
)

val Nototypography = Typography(
    h1 = TextStyle(
        fontFamily = Notofonts,
        fontWeight = FontWeight.Black,
    ),
    body1 = TextStyle(
        fontFamily = Notofonts,
        fontWeight = FontWeight.Medium
    ),
    body2 = TextStyle(
        fontFamily = Notofonts,
        fontWeight = FontWeight.Light
    )
)