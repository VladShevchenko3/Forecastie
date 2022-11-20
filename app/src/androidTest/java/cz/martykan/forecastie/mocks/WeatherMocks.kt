package cz.martykan.forecastie.mocks

interface WeatherMocks {

    fun givenLvivWithSunnyWeather() {
        mockWeather("data/2.5/weatherLviv", queryParams = mapOf("lang" to "en"))
        mockUvi()
        mockForecast()
    }

    fun givenKyivWithWithSunnyWeather() {
        mockWeather("data/2.5/weatherKyiv")
        mockUvi()
        mockForecast()
    }
}