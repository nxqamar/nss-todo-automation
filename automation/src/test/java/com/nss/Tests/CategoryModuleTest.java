package com.nss.Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.nss.Browser.Browser;
import com.nss.ExcelFunction.ExcelFunctions;
import com.nss.Pagefactory.nsstodoList;

public class CategoryModuleTest{
	nsstodoList ntl = new nsstodoList();
	ExcelFunctions ex = new ExcelFunctions();
	String Testname,taskname,color,catname,catlable,date;
	@Before
	public final void Setup()
	{
		System.out.println("i am in before method");
		//Any code to set precondition can be set here
	}

	@Test
	public final void TC011test()
	{   
	    System.out.println("This could be category Test");
	}

	
	@After
	public void TearDown()
	{	
	    ntl.Close();		
	}
	

}
