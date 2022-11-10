package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory
{
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    
    /**
     * This method is used to initialize the threadloacl driver on the basis of
     * given browser
     *
     * @param browser
     * @return this will return tldriver
     */
    public WebDriver init_driver(String browser)
    {
        System.out.println("Browser value is :" + browser);
        if (browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if (browser.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else if (browser.equals("safari"))
        {
            tlDriver.set(new SafariDriver());
        } else
        {
            System.out.println("Please correct the correct browwer value:" + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }
    
    /**
     * This is used to get the driver with ThreadLocal
     *
     * @return
     */
    public static synchronized WebDriver getDriver()
    {
        
        return tlDriver.get();// Retun the current instance of the webdriver
    }
}
