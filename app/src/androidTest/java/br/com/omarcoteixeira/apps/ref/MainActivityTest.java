package br.com.omarcoteixeira.apps.ref;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.omarcoteixeira.apps.ref.home.MainActivity;
import br.com.omarcoteixeira.apps.ref.robot.MainActivityRobot;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class, true, true);

    @Test
    public void basicSum() {
        MainActivityRobot robot = new MainActivityRobot();
        robot
                .addValue1(2)
                .addValue2(2)
                .sum()
                .isSuccess(4);
    }
}
