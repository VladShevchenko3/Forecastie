package cz.martykan.forecastie.tests

import androidx.test.core.app.ActivityScenario
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import cz.martykan.forecastie.MockDispatcher
import cz.martykan.forecastie.activities.MainActivity
import cz.martykan.forecastie.utils.BaseDomainHolder
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before

open class BaseTest : TestCase() {

    private lateinit var activityScenario: ActivityScenario<MainActivity>
    lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = MockDispatcher()
        mockWebServer.start()
        BaseDomainHolder.baseDomain = "http://${mockWebServer.hostName}:${mockWebServer.port}"
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
        activityScenario.close()
    }
}