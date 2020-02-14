package com.example.hamrobook_ebookstore;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MapInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);

    private String username = "admin";
    private String password = "admin";

    @Test
    public void MapUITest() {
        onView(withId(R.id.etUser))
                .perform(typeText(username));

        closeSoftKeyboard();

        onView(withId(R.id.etPass))
                .perform(typeText(password));

        closeSoftKeyboard();

        onView(withId(R.id.btnSign)).perform(click());

        onView(withId(R.id.navigation_setting_bar)).perform(click());

        onView(withId(R.id.relativeAbout)).perform(click());

    }
}
