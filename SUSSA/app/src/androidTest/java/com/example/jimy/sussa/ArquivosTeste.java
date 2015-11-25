package com.example.jimy.sussa;

import android.app.Activity;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Jimy on 25/11/15.
 */

@RunWith(AndroidJUnit4.class)

public class ArquivosTeste {

    @Rule public final ActivityTestRule<Arquivos> testArquivos = new ActivityTestRule<>(Arquivos.class);
    @Test
    public void deveAbrirActivity(){
        onView(withText("Upload")).check(matches(isDisplayed()));
    }
}
