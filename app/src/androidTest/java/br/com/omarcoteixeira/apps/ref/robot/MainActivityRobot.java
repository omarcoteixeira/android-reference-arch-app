package br.com.omarcoteixeira.apps.ref.robot;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;

import br.com.omarcoteixeira.apps.ref.R;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.Espresso.onView;


public class MainActivityRobot {

    public MainActivityRobot addValue1(long amount) {
        onView(withId(R.id.txtMainActivityValue1))
                .perform(typeText(String.valueOf(amount)), closeSoftKeyboard());
        return this;
    }


    public MainActivityRobot addValue2(long amount) {
        onView(withId(R.id.txtMainActivityValue2))
                .perform(typeText(String.valueOf(amount)), pressImeActionButton());
        return this;
    }

    public ResultRobot sum() {
        onView(withId(R.string.main_activity_button_sum))
                .perform(click());
        return new ResultRobot();
    }

    public class ResultRobot {
        private String getResourceString(int id) {
            Context targetContext = InstrumentationRegistry.getTargetContext();
            return targetContext.getResources().getString(id);
        }

        public void isSuccess(long amount) {
            String message = String.format(
                    getResourceString(R.string.main_activity_label_sum_result), String.valueOf(amount));
            onView(withText(message)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        }
    }
}
