package cz.martykan.forecastie.mocks

interface WeatherMocks {
    fun givenKyivWithSunnyWeather() {
        mockWeather("data/2.5/weather2")
        mockUvi()
        mockForecast()
    }

    fun mockWeatherWithLat() {
        mockWeather("",queryParams = mapOf("lat" to "37.4220936", "lon" to "-122.083922"))
    }

    fun givenKyivWithBadWeather() {
        mockWeather("data/2.5/weather")
        mockUvi()
        mockForecast()
    }
}