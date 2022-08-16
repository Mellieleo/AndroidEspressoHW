package ru.gb.gb_test.pages

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.not

class LoginPage {
    fun setUserName(name: String): LoginPage {
        Espresso.onView(withId(R.id.username)).perform(typeText(name))
        return this
    }

    fun setPassword(pass: String): LoginPage {
        Espresso.onView(withId(R.id.password)).perform(typeText(pass))
        return this
    }

    fun loginButtonIsEnabled(): LoginPage {
        Espresso.onView(withId(R.id.login)).check(matches(isEnabled()))
        return this
    }

    fun loginButtonIsDisabled(): LoginPage {
        Espresso.onView(withId(R.id.login)).check(matches(not(isEnabled())))
        return this
    }

    fun emailErrorText(): LoginPage {
        Espresso.onView(withId(R.id.login))
            .check(matches(hasErrorText("Not a valid username")))
        return this
    }

    fun passwordErrorText(): LoginPage {
        Espresso.onView(withId(R.id.password))
            .check(matches(hasErrorText("Password must be >5 characters")))
        return this
    }
}