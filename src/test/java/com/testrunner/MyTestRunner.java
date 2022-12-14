package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "D:\\JavaXps\\CucumberPOM\\src\\test\\resources\\com\\features" }, glue = {
        "com.stepdefenitions", "AppHooks" }, plugin = { "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/" }, monochrome = false)
public class MyTestRunner
{

}
