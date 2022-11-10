package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage
{
    private WebDriver driver;
    // 1.By locator
    private By accoutSection = By.cssSelector("div#center_column span");
    
    public AccountPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getAccountPageTitle()
    {
        return driver.getTitle();
    }

    public int getAcountSectionCount()
    {
        return driver.findElements(accoutSection).size();

    }
    
    public List<String> getAccountSectionList()
    {
        List<String> accoutList = new ArrayList<>();
        List<WebElement> accoutSectionList = driver.findElements(accoutSection);
        for (WebElement e : accoutSectionList)
        {
            String text = e.getText();
            System.out.println(text);
            accoutList.add(text);
        }
        return accoutList;
    }
}
