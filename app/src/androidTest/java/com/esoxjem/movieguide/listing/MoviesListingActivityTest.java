package com.esoxjem.movieguide.listing;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.esoxjem.movieguide.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * @author arunsasidharan
 */
@RunWith(AndroidJUnit4.class)
public class MoviesListingActivityTest
{
    @Rule
    public final ActivityTestRule<MoviesListingActivity> moviesListingActivityActivityTestRule = new ActivityTestRule<>(MoviesListingActivity.class);

    @Test
    public void shouldBeAbleToLaunchMainScreen()
    {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        onView(withId(R.id.action_sort)).check(matches(isDisplayed()));
    }
}
