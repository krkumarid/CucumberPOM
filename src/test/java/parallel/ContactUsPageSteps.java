package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.pages.ContactUsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsPageSteps
{
    private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());

    @Given("User navigates to contact us page")
    public void user_navigates_to_contact_us_page()
    {
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
    }

    @When("user fills the form from given {string} and {int}")
    public void user_fills_the_form_from_given_and(String sheetName, Integer rowNumber ) throws InvalidFormatException, IOException
    {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData = reader.getData("D:\\JavaXps\\CucumberPOM\\automation.xlsx", sheetName);
        
        String heading = testData.get(rowNumber).get("SubjectHeading");
        String email = testData.get(rowNumber).get("email");
        String orderReference = testData.get(rowNumber).get("orderref");
        String message = testData.get(rowNumber).get("message");
        contactUsPage.fillContactUsForm(heading, email, orderReference, message);
    }

    @When("user clicks on send button")
    public void user_clicks_on_send_button()
    {
        contactUsPage.clickSend();
    }

    @Then("It shows a successful message {string}")
    public void it_shows_a_successful_message(String expectedSuccessMsg )
    {
        String actualSuccessMsg = contactUsPage.getSuccessMsg();
        Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg );
    }

}
