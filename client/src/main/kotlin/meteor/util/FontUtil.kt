package meteor.util

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight


object FontUtil {

    val crimson = FontFamily(
        androidx.compose.ui.text.platform.Font(
            resource = "CrimsonPro-VariableFont_wght.ttf",
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        )
    )
    val righteous = FontFamily(
        androidx.compose.ui.text.platform.Font(
            resource = "Righteous-Regular.ttf",
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        )
    )
    val runescape = FontFamily(
        androidx.compose.ui.text.platform.Font(
            resource = "runescape.ttf",
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        )
    )
}