package com.epam.framework.core.listeners;

import com.epam.reportportal.message.ReportPortalMessage;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static com.epam.framework.core.drivers.DriverManager.takeScreenshot;
import static com.epam.framework.core.listeners.TALogger.info;

public class TAListener implements ITestListener {
    private static final String START = "Test suite has been started!";
    private static final String RUNNING = " is running at: ";
    private static final String SUCCESS = "- is SUCCESS";
    private static final String FAILED = "- is FAILED";
    private static final String SKIPPED = "has been skipped";
    private static final String FINISH = "Test suite finished!";
    public static final DateFormat FORMATTER = new SimpleDateFormat("mm-dd-yyyy HH:mm:ss:SSS");
    private static final String SUCCESS_MSG = "Test %s is ";

    public void onTestStart(ITestResult result) {
        info(String.format(SUCCESS_MSG, result.getMethod().getMethodName()) + RUNNING + FORMATTER.format(result.getStartMillis()));
    }

    public void onTestSuccess(ITestResult result) {
        info( String.format(SUCCESS_MSG, result.getMethod().getMethodName()) + SUCCESS);
        File screen = takeScreenshot();
        try {
            ReportPortalMessage message = new ReportPortalMessage(screen, FORMATTER.format(result.getStartMillis()));
            info(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestFailure(ITestResult result) {
        info(String.format(SUCCESS_MSG, result.getMethod().getMethodName()) + FAILED);
        File screen = takeScreenshot();
        try {
            ReportPortalMessage message = new ReportPortalMessage(screen, FORMATTER.format(result.getStartMillis()));
            info(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        info(String.format(SUCCESS_MSG, result.getMethod().getMethodName()) + SKIPPED);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {
        info(START);
    }

    public void onFinish(ITestContext context) {
        info(FINISH);
    }
}
