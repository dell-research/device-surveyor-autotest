package com.dell.research.devicesurveyor.test;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import java.io.File;

public class UIAutoTest extends UiAutomatorTestCase {
    public void test() throws UiObjectNotFoundException {
        // Get the initial state of the device
        getUiDevice().takeScreenshot(new File("/sdcard/uiautomator-screenshots/start-screen.png"));

        // Open the app
        getUiDevice().pressHome();
        UiObject allApps = new UiObject(new UiSelector().description("Apps"));
        allApps.clickAndWaitForNewWindow();
        getUiDevice().takeScreenshot(new File("/sdcard/uiautomator-screenshots/app-screen.png"));

        UiObject deviceSurveyApp = new UiObject(new UiSelector().className("android.widget.TextView").textContains("Device Surveyor"));
        deviceSurveyApp.clickAndWaitForNewWindow();
        getUiDevice().takeScreenshot(new File("/sdcard/uiautomator-screenshots/survey-screen.png"));

        // Submit device report
        UiObject submitButton = new UiObject(new UiSelector().className("android.widget.Button").textContains("SUBMIT"));
        submitButton.clickAndWaitForNewWindow();

        UiObject yesButton = new UiObject(new UiSelector().className("android.widget.Button").textContains("Yes"));
        yesButton.clickAndWaitForNewWindow();

        UiObject result = new UiObject(new UiSelector().className("android.widget.TextView").textContains("Successfully submitted"));
        assertTrue("Unsuccessful submission", result.exists());
    }
}