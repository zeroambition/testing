package com.testing.ozon.listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.testing.ozon.util.TakeScreenshot;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result){
        TakeScreenshot.takeScreenshot();
    }
}