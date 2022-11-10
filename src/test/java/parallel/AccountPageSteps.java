package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps
{
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountPage accoutPage;// = new AccountPage( DriverFactory.getDriver());

    @Given("user has already logged into the application")
    public void user_has_already_logged_into_the_application(DataTable credTable)
    {
        List<Map<String, String>> credList = credTable.asMaps(String.class, String.class);
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");
        
        DriverFactory.getDriver()
                .get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accoutPage = loginPage.doLogin(userName, password);
    }

    @Given("user is on the Accounts page")
    public void user_is_on_the_accounts_page()
    {
        String title = accoutPage.getAccountPageTitle();
        System.out.println(title);

    }

    @Then("user gets account section")
    public void user_gets_account_section(DataTable sectionsTable)
    {
        List<List<String>> expAccountSectionList = sectionsTable.asLists(String.class);
        System.out.println("Expected Account Section List:" + expAccountSectionList);
        List<String> actualAccoutSectionList = accoutPage.getAccountSectionList();
        System.out.println("Actual Account section List :" + actualAccoutSectionList);
        // Comparing two list
        // Assert.assertTrue(expAccountSectionList.contains(actualAccoutSectionList));
        Assert.assertTrue(expAccountSectionList.equals(actualAccoutSectionList));
    }
    
    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer expectedSectionCount)
    {
        System.out.println("Count:" + accoutPage.getAcountSectionCount());
        Assert.assertTrue(accoutPage.getAcountSectionCount() == expectedSectionCount);
        
    }

}
