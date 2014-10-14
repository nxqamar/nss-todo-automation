package com.nss.Browser;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.browserlaunchers.locators.GoogleChromeLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.nss.utilities.readproperties;

public class Browser 
{
	public  WebDriver driver=null;
	private readproperties ef = new readproperties();
	public  Browser(String browser)
	{
	    if(browser.equals("firefox"))
	    {
	        driver = new FirefoxDriver();
	    }
	    if(browser.equals("chrome"))
        {  
	        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("test-type");
	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	        driver = new ChromeDriver(capabilities);
        }
	    if(browser.equals("ie"))
        {
	        System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
	        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	        caps.setCapability(
	        InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
	            true);
	        driver = new InternetExplorerDriver(caps);
	        
	         
         //   driver = new InternetExplorerDriver();
        }
		driver.get(ef.readconfig("URL"));		
	}
	
	public final WebDriver OpenChrome()
	{
		driver = new ChromeDriver();
		return driver;	
	}
	
	public final WebDriver OpenIE()
	{
		driver = new InternetExplorerDriver();
		return driver;	
	}

}
