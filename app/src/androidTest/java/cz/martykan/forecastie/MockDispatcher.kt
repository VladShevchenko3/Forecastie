package cz.martykan.forecastie

import androidx.test.platform.app.InstrumentationRegistry
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest


class MockDispatcher : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        val response = request.requestUrl?.encodedPath?.let {
            MockResponse().setResponseCode(200).setBody(getFileContent(it))
        } ?: MockResponse().setResponseCode(400)
        return response
    }

}

fun getFileContent(path: String) =
    InstrumentationRegistry.getInstrumentation().context.assets
        .open("${path.drop(1)}.json").bufferedReader().readText()