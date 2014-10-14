package com.nss.Pagefactory;


import static org.junit.Assert.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nss.Browser.Browser;
import com.nss.Reusable.actions;

public class nsstodoList {
    int count=1;
	private By nsstitle = By.xpath("//div[@id='label-first']/b");
	private By catname = By.name("categorydata");
	private By taskname = By.name("data");
	private By addtaskbtn = By.xpath("//div[4]/input[2]");
	private By addCatbtn = By.xpath("//span[@id='extra']/input[2]");
	private By catLable = By.name("category");
	private By colorDrpDwn = By.name("colour");
	private By day = By.name("due_day");
	private By month = By.name("due_month");
	private By year = By.name("due_year");
	private By removebtn = By.xpath("//div[3]/input[1]");
	private By completebtn = By.xpath("//div[3]/input[2]");
	nsstodoTaskPage tskpage = new nsstodoTaskPage();
	String link = "//div[2]/form/ul/li["+count +"]/a";
	String checkbox = "//div[2]/form/ul/li["+count +"]/input";
	String tasklable = "//div[2]/form/ul/li["+count +"]/span";  
	String StrikeLable = "//div[2]/form/ul/li["+count +"]/strike";
	actions act = new actions();



	public void addCategory(String name, String color){
		
		//driver = ;
		//act = new actions();
		act.Click(nsstitle);
		act.Type(catname, name);
		if(!color.equalsIgnoreCase("None")){
		act.Select(colorDrpDwn, color);
		}
		act.Click(addCatbtn);
	}

public void AddTask(String name, String color,String Date){
		
		//driver = ;
		
		act.Click(nsstitle);
		act.Type(taskname, name);
		if(!color.equalsIgnoreCase("None")){
		act.SelectByIndex(catLable, 2);
		}
		if(!Date.equalsIgnoreCase("None")){
			String[]  str_array = Date.split("-");
			
			act.Select(day, str_array[0]);
			act.Select(month, str_array[1]);
			act.Select(year, str_array[2]);
		}
		act.Click(addtaskbtn);
		int count = 1;
	    boolean taskAdded = false;
	    By idLink = By.xpath(link);
	    By ckbox = By.xpath(checkbox);
	    while(act.IsElementPresent(idLink))
	     {
	        
	        act.Click(idLink);    
	        System.out.println(act.GetValue(tskpage.editTaskLable));
	        if(act.GetValue(tskpage.editTaskLable).equals(name))
	        {
	            act.browserBack();
	            taskAdded = true;
	            break;
	        }else 
	        {
	            act.browserBack();
	        }
	        
	        count++;
	        link = "//div[2]/form/ul/li["+count +"]/a";
	        checkbox = "//div[2]/form/ul/li["+count +"]/input";
	        tasklable = "//div[2]/form/ul/li["+count +"]"; 
	        ckbox = By.xpath(checkbox);
	        idLink = By.xpath(link);
	        
	     }
	    if(taskAdded==true)
	    {
	        System.out.println("Task Sucessfully Added");   
	    }else
	    {
	      
	        fail("Task not Added");
	        
	    }
		
	}

public void RemoveTask(String name){
    int count = 1;
    boolean taskedeleted = false;
    By idLink = By.xpath(link);
    By ckbox = By.xpath(checkbox);
    while(act.IsElementPresent(idLink))
     {
        
        act.Click(idLink);    
        System.out.println(act.GetValue(tskpage.editTaskLable));
        if(act.GetValue(tskpage.editTaskLable).equals(name))
        {
            act.browserBack();
            act.Click(ckbox);
            act.Click(removebtn);
            taskedeleted = true;
            break;
        }else 
        {
            act.browserBack();
        }
        
        count++;
        link = "//div[2]/form/ul/li["+count +"]/a";
        checkbox = "//div[2]/form/ul/li["+count +"]/input";
        tasklable = "//div[2]/form/ul/li["+count +"]"; 
        ckbox = By.xpath(checkbox);
        idLink = By.xpath(link);
        
     }
    if(taskedeleted==true)
    {
        System.out.println("Task found and deleted");   
    }else
    {
        fail("Task not found");
    }
}
    public void CompleteTask(String name){
       boolean taskCompleted = false;
        int count = 1;
        By idLink = By.xpath(link);
        By ckbox = By.xpath(checkbox);
        By strikelab = By.xpath(StrikeLable);
        while(act.IsElementPresent(idLink))
         {
            
            act.Click(idLink);    
            System.out.println(act.GetValue(tskpage.editTaskLable));
            if(act.GetValue(tskpage.editTaskLable).equals(name))
            {
                act.browserBack();
                act.Click(ckbox);
                act.Click(completebtn);
                taskCompleted = act.IsElementPresent(strikelab);
                break;
            }else 
            {
                act.browserBack();
            }
            
            count++;
            link = "//div[2]/form/ul/li["+count +"]/a";
            checkbox = "//div[2]/form/ul/li["+count +"]/input";
            tasklable = "//div[2]/form/ul/li["+count +"]"; 
            StrikeLable = "//div[2]/form/ul/li["+count +"]/strike";
            ckbox = By.xpath(checkbox);
            idLink = By.xpath(link);
            strikelab = By.xpath(StrikeLable);
            
         }
        if(taskCompleted==true)
        {
            System.out.println("Task found and completed");   
        }else
        {
            fail("Task not found");
        }
        
}
	public void Close() {
		
		
		act.close();
	}
	
}

