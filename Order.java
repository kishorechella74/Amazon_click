package kishore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;

import Day_018_Waits.Reporter1;

public class Order {
	  WebDriver driver;
	  static Reporter1 R1;
	public  void Order(WebDriver driver) 
	{
		this.driver = driver;

	}
	
	public void Order() throws Exception
	{
	
		String str = "Amazon_Demo";
		R1 = new Reporter1(driver, str);
		
		findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Hoodies for men");
		findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		//findElement(By.xpath("//*[@id=\"anonCarousel5\"]/ol/li[2]/div/a")).click();
		
		//@scroll_down
		WebElement Element = findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[14]/div/span/div/div/div[3]/div[2]/h2/a/span"));
		
		
		
		 JavascriptExecutor js = (JavascriptExecutor)driver;		
	  
	 	js.executeScript("arguments[0].click();", Element);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		
		//findElement(By.xpath("//*[@id=\"a-autoid-5-announce\"]/div/div[1]/img")).click();

		
		
//		// @Dropdown_Value
//		Select dropdown1 = new Select(
//				findElement(By.name("//*[@id=\"native_dropdown_selected_size_name\"]")));
//
//		dropdown1.selectByValue("3,B098B7RJYM");
//		
//		findElement(By.xpath("//*[@id=\"add-to-wishlist-button\"]")).click();
//		findElement(By.xpath("//*[@id=\"atwl-list-name-225DFLYM7NO9W\"]")).click();
//		findElement(By.xpath("//*[@id=\"WLHUC_continue\"]")).click();
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

