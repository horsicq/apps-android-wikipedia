package org.wikipedia.homeworks.homework09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class InTheNewsTestScreen : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun inTheNewsTest() {
        run {
            step("Skipping") {
                OnboardingScreen.skipButton.click()
            }
            step("Check block 'In the news'") {
                ExploreScreen.items.childWith<InTheNewsCardItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }.perform {
                    inTheNewsHeaderTitle.hasAnyText()
                }
            }
            step("Click on the 3rd image") {
                ExploreScreen.items.childWith<InTheNewsCardItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }.perform {
                    newsCardReaderItems.childAt<NewsCardItem>(2) {
                        newsCardImage.click()
                    }
                }
            }
            step("Click on the 2nd item in the list") {
                FragmentNews.newsStoryItemsRecycler.childAt<NewsCardItems>(1) {
                    newsCardItemTitle.click()
                }
            }
            step("Check news page") {
                NewsPage.newsPageWebView.isDisplayed()
            }
        }
    }
}


