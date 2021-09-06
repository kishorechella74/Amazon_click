package kishore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import Day_018_Waits.Reporter1;

public class Logout {
    WebDriver driver;
    static Reporter1 R1;
    
	public void Logout(WebDriver driver) 
	{
		
		this.driver = driver;
		
	}


	public  void logout() throws Exception
	{

		String str = "Amazon_Demo";
		R1 = new Reporter1(driver, str);
		
		//@Mouse_Hover
		WebElement out = findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
		
		WebElement bye = findElement(By.xpath(" //*[@id=\"nav-item-signout\"]/span"));
		
		R1.TakeScreenShotAuto(driver, "signout", "Pass");
		
		Actions actions = new Actions(driver);

		actions.moveToElement(out).moveToElement(bye).click().build().perform();
		
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
