package com.nss.Tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.nss.Browser.Browser;
import com.nss.ExcelFunction.ExcelFunctions;
import com.nss.Pagefactory.nsstodoList;

public class TaskModuleTest{
	nsstodoList ntl = new nsstodoList();
	ExcelFunctions ex = new ExcelFunctions();
	String Testname,taskname,color,catname,catlable,date;
	@Before
	public final void Setup()
	{
		System.out.println("i am in before method");	
	}

	@Test
	public final void TC001test()
	{   Testname = "TC001" ;
	    taskname = ex.ReadTestData("TCData.xls", Testname, "taskname");
	    catlable = ex.ReadTestData("TCData.xls", Testname, "catlable");
	    date = ex.ReadTestData("TCData.xls", Testname, "date");
		ntl.AddTask( taskname,catlable,date);
	
	}

	@Test
	public final void TC002test()
	{  Testname = "TC002" ;
	taskname = ex.ReadTestData("TCData.xls", Testname, "taskname");
    catlable = ex.ReadTestData("TCData.xls", Testname, "catlable");
    date = ex.ReadTestData("TCData.xls", Testname, "date");
    ntl.AddTask( taskname,catlable,date);
	}

	@Test
    public final void TC003test()
    {  Testname = "TC003" ;
    taskname = ex.ReadTestData("TCData.xls", Testname, "taskname");
    catlable = ex.ReadTestData("TCData.xls", Testname, "catlable");
    date = ex.ReadTestData("TCData.xls", Testname, "date");
    ntl.AddTask( taskname,catlable,date);
    }
	
	
	@Test
    public final void TC004test()
    {  Testname = "TC004" ;
    taskname = ex.ReadTestData("TCData.xls", Testname, "taskname");
    catlable = ex.ReadTestData("TCData.xls", Testname, "catlable");
    date = ex.ReadTestData("TCData.xls", Testname, "date");
    ntl.AddTask( taskname,catlable,date);
    ntl.RemoveTask(taskname);
    }
	
	@Test
    public final void TC005test()
    {  Testname = "TC005" ;
    taskname = ex.ReadTestData("TCData.xls", Testname, "taskname");
    catlable = ex.ReadTestData("TCData.xls", Testname, "catlable");
    date = ex.ReadTestData("TCData.xls", Testname, "date");
    ntl.AddTask( taskname,catlable,date);
    ntl.CompleteTask(taskname);
    ntl.RemoveTask(taskname);
    }
	
	@After
	public void TearDown()
	{	
	    ntl.Close();		
	}
	

}
