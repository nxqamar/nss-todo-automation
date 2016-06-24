package TestAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class locateObj {

	public static void main(String[] args) {
		String myurl="http://localhost:81/nss-todo-automation-alpha/index.php";
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Amisha\\Desktop\\Mydata\\selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get(myurl);
		
		/*WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement cb1 = driver.findElement(By.name("todo[3]"));
		 cb1.click();
		*/
		
		driver.findElement(By.name("data")).sendKeys("WALKING");
		
		
		
		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		Select list1= new Select(driver.findElement(By.name("category")));
		list1.selectByIndex(6);
		
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		Select list2= new Select(driver.findElement(By.name("due_day")));
		list2.selectByIndex(3);
		
		WebDriverWait wait3= new WebDriverWait(driver, 5);
		Select list3= new Select(driver.findElement(By.name("due_month")));
		list3.selectByIndex(4);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//html/body/div[4]/input[2]")).click();
		
		driver.findElement(By.name("categorydata")).sendKeys("Amisha's AI");
		
		driver.findElement(By.xpath(".//*[@id='extra']/input[2]")).click();
		
	
	

	}

}
