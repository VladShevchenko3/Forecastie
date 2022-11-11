package cz.martykan.forecastie.screens

import com.kaspersky.kaspresso.screens.KScreen
import cz.martykan.forecastie.R
import cz.martykan.forecastie.activities.MainActivity
import io.github.kakaocup.kakao.text.KButton

object MainScreen : KScreen<MainScreen>() {

    override val layoutId = R.layout.abc_action_menu_layout
    override val viewClass = MainActivity::class.java

    private val refreshButton = KButton { withId(R.id.action_refresh) }

    fun actionClickOnRefreshButton() {
        refreshButton.click()
    }
}