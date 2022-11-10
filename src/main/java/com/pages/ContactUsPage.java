package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage
{
    private WebDriver driver;
    //1.By Locator
    private By selectSubHead = By.id("id_contact");
    private By email = By.id("email");
    private By orderRef = By.id("id_order");
    private By messageArea = By.id("message");
    private By sendMessage = By.id("submitMessage");
    private By successMsg = By.xpath("//div[@id ='center_column']/p");
    public ContactUsPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public String getContactUsPageTitle()
    {
        return driver.getTitle();
    }
    public void fillContactUsForm( String heading,String emailId, String orderReference,String message )
    {
        Select select = new Select( driver.findElement(selectSubHead));
        select.selectByVisibleText( heading );
        driver.findElement(email).sendKeys( emailId );
        driver.findElement(orderRef).sendKeys(orderReference);
        driver.findElement(messageArea).sendKeys(message);
        
        
    }
    public void clickSend()
    {
        driver.findElement(sendMessage).click();
    }
    public String getSuccessMsg()
    {
        return driver.findElement(successMsg).getText();
    }
}
