package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "D:\\JavaXps\\CucumberPOM\\src\\test\\resources\\parallel" }, glue = {
        "parallel" }, tags = "not @Skip", plugin = { "pretty", }, monochrome = true)
public class MySerenityTestRunner
{
    
}
