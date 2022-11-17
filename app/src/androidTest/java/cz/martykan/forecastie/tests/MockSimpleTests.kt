package cz.martykan.forecastie.tests

import cz.martykan.forecastie.mocks.WeatherMocks
import cz.martykan.forecastie.mocks.mockForecast
import cz.martykan.forecastie.mocks.mockWeather
import cz.martykan.forecastie.screens.MainScreen
import org.junit.Test

class MockSimpleTests : BaseTest(), WeatherMocks {

    @Test
    fun test() = run {
        mockWeather()
        mockForecast()
        step("Click on the refresh button on MainScreen") {
            MainScreen {
                actionClickOnRefreshButton()
            }
        }
        Thread.sleep(5000)
    }

    @Test
    fun test2() = run {
        mockForecast()
        givenKyivWithSunnyWeather()
        mockWeatherWithLat()
        givenKyivWithBadWeather()
        step("Click on the refresh button on MainScreen") {
            MainScreen {
                actionClickOnRefreshButton()
            }
        }
        Thread.sleep(5000)
    }
}