package parallel;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "D:\\JavaXps\\CucumberPOM\\src\\test\\resources\\parallel\\LoginPage.feature" }, glue = {
        "parallel" }, /* tags = "not @Skip", */ plugin = { "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:test-output-thread/",
                "rerun:target/failedRerun.txt" }, monochrome = true)
public class ParallelTestRunner extends AbstractTestNGCucumberTests
{
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }
}
