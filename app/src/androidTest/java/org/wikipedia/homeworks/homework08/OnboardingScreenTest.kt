package org.wikipedia.homeworks.homework08

import androidx.test.espresso.action.GeneralLocation
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingScreenTest: TestCase() {
    @get:Rule
    val activityTestRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun skipButtonTest() {
        run {
            step("Check Skip Button") {
                OnboardingScreen.skipButton.isDisplayed()
            }
        }
    }

    @Test
    fun continueButtonTest() {
        run {
            step("Check Continue Button") {
                OnboardingScreen.continueButton.isDisplayed()
            }
        }
    }

    @Test
    fun addLanguagesButtonTest() {
        run {
            step("Check add or edit Languages button") {
                OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                    addOrEditLanguagesButton.isDisplayed()
                }
            }
        }
    }
}
