package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    private WebDriver driver;

    // 1. By locators ( Object Repository )
    private By emailId = By.id("email");
    private By password = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By forgotPwdLink = By.linkText("Forgot your password?");

    // 2. Constructor of the Page Class
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    // 3.Page action :features( behaviour ) of the page the form of methods

    public String getLoginPageTitle()
    {

        return driver.getTitle();

    }

    public boolean isForgotPwdLinkExists()
    {

        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUserName(String userName)
    {

        driver.findElement(emailId).sendKeys(userName);
    }

    public void enterPassword(String pwd)
    {

        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin()
    {

        driver.findElement(signInButton).click();
    }

    public AccountPage doLogin(String userName, String pword)
    {
        System.out.println("Login with :" + userName + "and " + pword);
        driver.findElement(emailId).sendKeys(userName);
        driver.findElement(password).sendKeys(pword);
        driver.findElement(signInButton).click();
        return new AccountPage(driver);
    }
}
