package meteor.ui.themes

import com.formdev.flatlaf.IntelliJTheme

class MeteorliteTheme private constructor(theme: IntelliJTheme) : IntelliJTheme.ThemeLaf(theme) {

    override fun getName(): String {
        return "meteor"
    }

    companion object {

        fun install() {
            val theme = MeteorliteTheme(IntelliJTheme(MeteorliteTheme::class.java.getResourceAsStream("/themes/meteorlite.theme.json")))
            setup(theme)
        }
    }
}
