package cz.martykan.forecastie.mocks

import androidx.test.platform.app.InstrumentationRegistry
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class MockDispatcher : Dispatcher() {

    companion object {
        val requestResponseList = mutableListOf<RequestResponse>()
    }

    override fun dispatch(request: RecordedRequest): MockResponse {
        requestResponseList.find {
            it.predicate(request)
        }?.let {
            return it.response
        } ?: return MockResponse().setResponseCode(400)

    }
}

fun getFileContent(path: String) =
    InstrumentationRegistry.getInstrumentation().context.assets
        .open("${path}.json").bufferedReader().readText()