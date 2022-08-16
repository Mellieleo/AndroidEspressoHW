package ru.gb.gb_test.tests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.gb.gb_test.pages.LoginPage
import ru.gb.gb_test.ui.login.LoginActivity

@RunWith(AndroidJUnit4::class)
class LoginPageTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkLoginButtonIsDisplayed() {
        onView(withId(R.id.login)).check(matches(isDisplayed()))
    }

    @Test
    fun checkLoginButtonIsDisabled() {
        LoginPage().loginButtonIsDisabled()
    }

    @Test
    fun checkLoginButtonIsEnabled() {
        LoginPage().setUserName("Some@usr.nm").setPassword("qwerty").loginButtonIsEnabled()
    }

    @Test
    fun checkLoginButtonIsDisabledWithUNFilled() {
        LoginPage().setUserName("Some@usr.nm").loginButtonIsDisabled().passwordErrorText()
    }

    @Test
    fun checkLoginButtonIsDisabledWithPWFilled() {
        LoginPage().setPassword("qwerty").loginButtonIsDisabled().emailErrorText()
    }
}