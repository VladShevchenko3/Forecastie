package cz.martykan.forecastie.tests

import cz.martykan.forecastie.screens.MainScreen
import org.junit.Test

class MockSimpleTests : BaseTest() {

    @Test
    fun test() = run {
        step("Click on the refresh button on MainScreen") {
            MainScreen {
                actionClickOnRefreshButton()
            }
        }
        Thread.sleep(10000)
    }
}