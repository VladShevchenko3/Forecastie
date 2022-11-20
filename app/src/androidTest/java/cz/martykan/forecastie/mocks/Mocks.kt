package cz.martykan.forecastie.mocks

import okhttp3.mockwebserver.MockResponse

fun mockWeather(
    filePath: String = "data/2.5/weather",
    queryParams: Map<String, String> = emptyMap()
) {
    val weatherRequestResponse =
        RequestResponse(MockResponse().setBody(getFileContent(filePath))) { request ->
            var flag = true
            if (request.requestUrl?.encodedPath == "/data/2.5/weather") {
                queryParams.forEach {
                    flag = flag && request.requestUrl?.queryParameter(it.key) == it.value
                }
                return@RequestResponse flag
            }
            return@RequestResponse false
        }
    MockDispatcher.requestResponseList.add(weatherRequestResponse)
}

fun mockForecast(
    filePath: String = "data/2.5/forecast"
) {
    val forecastRequestResponse =
        RequestResponse(MockResponse().setBody(getFileContent(filePath))) {
            it.requestUrl?.encodedPath == "/data/2.5/forecast"

        }

    MockDispatcher.requestResponseList.add(forecastRequestResponse)
}

fun mockUvi(filePath: String = "data/2.5/uvi") {
    val uviRequestResponse = RequestResponse(MockResponse().setBody(getFileContent(filePath))) {
        it.requestUrl?.encodedPath == "/data/2.5/uvi"
    }
    MockDispatcher.requestResponseList.add(uviRequestResponse)
}