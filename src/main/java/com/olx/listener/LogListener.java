package com.olx.listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class LogListener implements ITestListener {
    final static Logger LOGGER = LoggerFactory.getLogger(LogListener.class);

    @Override
    public void onTestStart(ITestResult tr) {
        LOGGER.info("Test start" + tr.getMethod().getMethodName() + " start");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        LOGGER.info("Test " + tr.getMethod().getMethodName() + " finished success");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        LOGGER.info("Test " + tr.getMethod().getMethodName() + " failed");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        LOGGER.info("Test" + tr.getMethod().getMethodName() + " skipped");
    }

}
