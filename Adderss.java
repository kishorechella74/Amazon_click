package kishore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Day_018_Waits.Reporter1;

public class Adderss {

	
	WebDriver driver;
	static Reporter1 R1;
	public void Address(WebDriver driver) 
	{
		
		this.driver = driver;
		
	}

	public  void AddAddress() throws Exception
	{
		
		String str = "Amazon_Demo";
		R1 = new Reporter1(driver, str);
	
		

		//@Mouse_Hover
		WebElement deliver = findElement(By.xpath("//*[@id=\"nav-global-location-popover-link\"]"));
		
		R1.TakeScreenShotAuto(driver, "deliver", "Pass");
		
		Actions actions = new Actions(driver);

		actions.moveToElement(deliver).click().build().perform();
		

		WebElement add = findElement(By.xpath("//*[@id=\"GLUXManageAddressLink\"]/a"));
		R1.TakeScreenShotAuto(driver, "Add", "Pass");
		Thread.sleep(2000);

		actions.moveToElement(add).click().build().perform();

		findElement(By.xpath("//*[@id=\"ya-myab-plus-address-icon\"]")).click();
		
		R1.TakeScreenShotAuto(driver, "AddAddress", "Pass");

		findElement(By.xpath("//*[@id=\"address-ui-widgets-countryCode\"]/span/span")).click();
		
		R1.TakeScreenShotAuto(driver, "ADD_Button", "Pass");

		// @Dropdown_Value
		Select dropdown1 = new Select(
				findElement(By.name("address-ui-widgets-countryCode")));

		dropdown1.selectByValue("IN");

		Thread.sleep(3000);
		
		
		
		
		findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFullName\"]")).sendKeys("kishore");
		
		R1.TakeScreenShotAuto(driver, "ADD_Name", "Pass");

		findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]")).sendKeys("8500965690");
		R1.TakeScreenShotAuto(driver, "ADD_Numbr", "Pass");
		findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPostalCode\"]")).sendKeys("518222");
		R1.TakeScreenShotAuto(driver, "ADD_pincode", "Pass");
		findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressLine1\"]")).sendKeys("h:no-8-140-31");
		R1.TakeScreenShotAuto(driver, "ADD_h:no", "Pass");
		findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressLine2\"]")).sendKeys("Srinivasa Nagar");
		R1.TakeScreenShotAuto(driver, "ADD_colony", "Pass");
		findElement(By.xpath("//*[@id=\"address-ui-widgets-landmark\"]")).sendKeys("Messiya Church Street");
		R1.TakeScreenShotAuto(driver, "ADD_near", "Pass");
		
		
		//@Dropdown_VisibleText
		Select dropdown2 = new Select(
				findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId\"]")));

		dropdown2.selectByVisibleText("ANDHRA PRADESH");
		
		
		findElement(By.xpath("//*[@id=\"address-ui-widgets-use-as-my-default\"]")).click();
		
		
		
		//@Dropdown_Index
		Select dropdown3 = new Select(
				findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFormContainer\"]/div[3]/div[4]/span/select")));

		dropdown3.selectByIndex(2);
		Thread.sleep(3000);
		
	}
	
	
	public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
	


}
