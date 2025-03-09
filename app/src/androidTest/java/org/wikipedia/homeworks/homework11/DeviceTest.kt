package org.wikipedia.homeworks.homework11

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.device.exploit.Exploit
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.wikipedia.homeworks.homework10.OnboardingScreen

class DeviceTest : TestCase() {
    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testClickHomeButton() {
        run {
            step("Check button before") {
                OnboardingScreen.continueButton.isDisplayed()
            }
            step("Click home button") {
                device.exploit.pressHome()
            }
            step("Check button after") {
                OnboardingScreen.continueButton.isDisplayed()
            }
        }
    }

    @Test
    fun testToggleWifiA() {
        run {
            device.network.toggleWiFi(false)
            Thread.sleep(1000)
            device.network.toggleWiFi(true)
        }
    }

    @Test
    fun testRotateScreen() {
        run {
            val orientationBeforeRotation = device.uiDevice.isNaturalOrientation
            step("Rotate screen") {
                device.exploit.setOrientation(Exploit.DeviceOrientation.Landscape)
                Thread.sleep(1000)
            }

            val orientationAfterRotation = device.uiDevice.isNaturalOrientation

            step("Check orientation") {
                Assert.assertNotEquals(
                    "Orientation not changed",
                    orientationBeforeRotation, orientationAfterRotation
                )
            }
        }
    }
}