package org.wikipedia.homeworks.homework13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework09.DayHeaderCardViewItem
import org.wikipedia.homeworks.homework09.ExploreScreen.items
import org.wikipedia.homeworks.homework09.OnboardingScreen
import org.wikipedia.homeworks.homework09.ExploreScreen
import org.wikipedia.homeworks.homework09.InTheNewsCardItem
import org.wikipedia.main.MainActivity

class WebViewTest : TestCase() {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testWebView() = run {
        step("Skip Onboarding") {
            OnboardingScreen.skipButton.click()
        }

        step("Get item on ExploreScreen") {
            ExploreScreen.items.childWith<InTheNewsCardItem> {
                withDescendant { withText(R.string.view_card_news_title) }
            }.invoke {
                items.childAt<DayHeaderCardViewItem>(0) {
                    click()
                }
            }
        }
        step("Scroll to reference element") {
            flakySafely(10000) {
                WebViewScreen.currentView {
                    withElement(Locator.ID, "References") {
                        scroll()
                    }
                }
            }
        }
        step("Check References text") {
            WebViewScreen.currentView {
                withElement(Locator.ID, "References") {
                    hasText("References")
                }
            }
        }
        step("Xpath to link #5") {
            WebViewScreen.currentView {
                withElement(
                    Locator.XPATH, "//sup[@id='cite_ref-Universal_5-0") {
                    click()
                }
            }
        }
        step("Check link #5 text") {
            WebViewScreen.currentView {
                withElement(
                    Locator.XPATH, "//sup[@id='cite_ref-Universal_5-0") {
                    hasText("5")
                }
            }
        }
    }
}