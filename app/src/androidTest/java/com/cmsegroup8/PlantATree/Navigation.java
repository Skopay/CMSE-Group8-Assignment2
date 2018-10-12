package com.cmsegroup8.PlantATree;


import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class Navigation {

    @Rule
    public ActivityTestRule<Home> mActivityTestRule = new ActivityTestRule<>(Home.class);

    @Test
    public void navigation() {
        ViewInteraction frameLayout = onView(allOf(withId(R.id.navigation_home), withContentDescription("Home"), childAtPosition(childAtPosition(withId(R.id.bottomNavView_Bar), 0), 0), isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

        ViewInteraction frameLayout2 = onView(allOf(withId(R.id.navigation_home), withContentDescription("Home"), childAtPosition(childAtPosition(withId(R.id.bottomNavView_Bar), 0), 0), isDisplayed()));
        frameLayout2.check(matches(isDisplayed()));

        ViewInteraction frameLayout3 = onView(allOf(withId(R.id.navigation_home), withContentDescription("Home"), childAtPosition(childAtPosition(withId(R.id.bottomNavView_Bar), 0), 0), isDisplayed()));
        frameLayout3.check(matches(isDisplayed()));

        ViewInteraction bottomNavigationItemView = onView(allOf(withId(R.id.navigation_Search), withContentDescription("Search"), childAtPosition(childAtPosition(withId(R.id.bottomNavView_Bar), 0), 1), isDisplayed()));
        bottomNavigationItemView.perform(click());

        DataInteraction appCompatTextView = onData(anything()).inAdapterView(allOf(withId(R.id.thelist), childAtPosition(withClassName(is("android.widget.RelativeLayout")), 1))).atPosition(0);
        appCompatTextView.perform(click());

        ViewInteraction appCompatButton = onView(allOf(withId(R.id.purchase), withText("Purchase"), childAtPosition(allOf(withId(R.id.relativeLayout), childAtPosition(withClassName(is("android.widget.LinearLayout")), 0)), 7)));
        appCompatButton.perform(scrollTo(), click());

    }

    private static Matcher<View> childAtPosition(final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent) && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
