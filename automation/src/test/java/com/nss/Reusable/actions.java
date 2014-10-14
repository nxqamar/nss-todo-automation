package com.nss.Reusable;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.nss.Browser.Browser;
import com.nss.utilities.readproperties;

public class actions {
    private readproperties ef = new readproperties();
    WebDriver driver= null;
	public actions(){
	    
		driver = (new Browser(ef.readconfig("browser"))).driver;
	}
	
	public final void Click(final By webelement)
	{
		driver.findElement(webelement).click();
	//	driver.
	}
	public final void browserBack()
    {
        driver.navigate().back();
    //  driver.
    }
	
	public final void Type(final By webelement, final String name)
	{
		driver.findElement(webelement).clear();
		driver.findElement(webelement).sendKeys(name);
	}
	public final void Select(final By webelement, final String lable)
	{
		new Select(driver.findElement(webelement)).selectByVisibleText(lable);
	}
	public final boolean IsElementPresent(final By locator) 
	{
	        try {
	          driver.findElement(locator);
	          return true;
	        } catch (Exception e) {
	          return false;
	        }       
    }
	public final String GetText(final By webelement) 
    {
          return  driver.findElement(webelement).getText();
           
    }
	
	public final String GetValue(final By webelement) 
    {
          return  driver.findElement(webelement).getAttribute("value");
           
    }
	public final WebElement GetWebElement(final By by) 
    {
          return  driver.findElement(by);
           
    }

	public final void close() {
		
		driver.quit();
		
	}

	public final void SelectByIndex(final By webelement, final int index) {
		new Select(driver.findElement(webelement)).selectByIndex(index);
		
	}
}
