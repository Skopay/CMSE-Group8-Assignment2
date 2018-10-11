package com.cmsegroup8.searchba;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class Palm_TreeTest {

    @Rule
    public ActivityTestRule<Palm_Tree> mActivityTestRule = new ActivityTestRule<>(Palm_Tree.class);

    @Test
    public void palm_TreeTest() {
        ViewInteraction textView = onView(allOf(withText("Plant A Tree"), childAtPosition(allOf(withId(R.id.action_bar), childAtPosition(withId(R.id.action_bar_container), 0)), 0), isDisplayed()));
        textView.check(matches(withText("Plant A Tree")));

        ViewInteraction imageView = onView(allOf(withContentDescription("More options"), childAtPosition(childAtPosition(withId(R.id.action_bar), 1), 0), isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction imageView2 = onView(allOf(withId(R.id.palmtree), childAtPosition(allOf(withId(R.id.relativeLayout), childAtPosition(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class), 0)), 0), isDisplayed()));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(allOf(withId(R.id.Facts), withText("Facts"), childAtPosition(allOf(withId(R.id.relativeLayout), childAtPosition(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class), 0)), 1), isDisplayed()));
        textView2.check(matches(withText("Facts")));

        ViewInteraction textView3 = onView(allOf(withId(R.id.common_name), withText("Common Name: Palm"), childAtPosition(allOf(withId(R.id.relativeLayout), childAtPosition(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class), 0)), 2), isDisplayed()));
        textView3.check(matches(withText("Common Name: Palm")));

        ViewInteraction textView4 = onView(allOf(withId(R.id.Tree_info), withText("Palms are one of the best known and most widely planted tree families.They have held an important role for humans throughout much of history.Many common products and foods come from palms.They are often used in parks and gardens that are in areas that do not have heavy frosts.In the past palms were symbols of victory, peace, and fertility.Today palms are a popular symbol for the tropics and for vacations."), childAtPosition(allOf(withId(R.id.relativeLayout), childAtPosition(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class), 0)), 3), isDisplayed()));
        textView4.check(matches(withText("Palms are one of the best known and most widely planted tree families.They have held an important role for humans throughout much of history.Many common products and foods come from palms.They are often used in parks and gardens that are in areas that do not have heavy frosts.In the past palms were symbols of victory, peace, and fertility.Today palms are a popular symbol for the tropics and for vacations.")));

        ViewInteraction textView5 = onView(allOf(withId(R.id.Price_Title), withText("Price"), childAtPosition(allOf(withId(R.id.relativeLayout), childAtPosition(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class), 0)), 4), isDisplayed()));
        textView5.check(matches(withText("Price")));

        ViewInteraction textView6 = onView(allOf(withId(R.id.Price), withText("$30.00 Each"), childAtPosition(allOf(withId(R.id.relativeLayout), childAtPosition(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class), 0)), 5), isDisplayed()));
        textView6.check(matches(withText("$30.00 Each")));

        ViewInteraction button = onView(allOf(withId(R.id.subtract_btn), childAtPosition(allOf(withId(R.id.layout), childAtPosition(withId(R.id.quantity_button), 0)), 0), isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction textView7 = onView(allOf(withId(R.id.number_counter), withText("1"), childAtPosition(allOf(withId(R.id.layout), childAtPosition(withId(R.id.quantity_button), 0)), 1), isDisplayed()));
        textView7.check(matches(withText("1")));

        ViewInteraction button2 = onView(allOf(withId(R.id.add_btn), childAtPosition(allOf(withId(R.id.layout), childAtPosition(withId(R.id.quantity_button), 0)), 2), isDisplayed()));
        button2.check(matches(isDisplayed()));

        ViewInteraction button3 = onView(allOf(withId(R.id.purchase), childAtPosition(allOf(withId(R.id.relativeLayout), childAtPosition(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class), 0)), 7), isDisplayed()));
        button3.check(matches(isDisplayed()));

        ViewInteraction relativeLayout = onView(allOf(withId(R.id.relativeLayout), childAtPosition(childAtPosition(IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class), 0), 0), isDisplayed()));
        relativeLayout.check(matches(isDisplayed()));

        ViewInteraction frameLayout = onView(allOf(withId(R.id.navigation_home), withContentDescription("Home"), childAtPosition(childAtPosition(withId(R.id.bottomNavView_Bar), 0), 0), isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

        ViewInteraction frameLayout2 = onView(allOf(withId(R.id.navigation_Search), withContentDescription("Search"), childAtPosition(childAtPosition(withId(R.id.bottomNavView_Bar), 0), 1), isDisplayed()));
        frameLayout2.check(matches(isDisplayed()));

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
