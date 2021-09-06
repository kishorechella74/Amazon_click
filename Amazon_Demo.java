package kishore;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import Day_018_Waits.Reporter1;

import static org.testng.Assert.*;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Amazon_Demo {
	WebDriver driver;
	static Reporter1 R1;
	

	@BeforeMethod
    public void openchrome() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\venka\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String str = "TC01_Login";
		R1 = new Reporter1(driver, str);
		
		
		
		
	}
	// Draws a red border around the found element. Does not set it back anyhow.
	public WebElement findElement(By by) throws Exception {

		WebElement elem = driver.findElement(by);
		// draw a border around the found element

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid orange'", elem);

		}

		return elem;
	}

	@Test
	public void name() throws Exception {
	

		String TestURL = "https://www.amazon.in/?ie=UTF8&ext_vrnc=hi&tag=googhydrabk-21&ascsubtag=_k_CjwKCAjwgviIBhBkEiwA10D2jwla8RMPgslMnd2TWS241T1koJXmlTH9Dq_QumZ2USiTw1X4yF_SkhoCf40QAvD_BwE_k_&ext_vrnc=hi&gclid=CjwKCAjwgviIBhBkEiwA10D2jwla8RMPgslMnd2TWS241T1koJXmlTH9Dq_QumZ2USiTw1X4yF_SkhoCf40QAvD_BwE";
		driver.get(TestURL);
		R1.TakeScreenShotAuto(driver, "openamazon", "Pass");

		Thread.sleep(1000);
        
		
		
		//@Mouse_Hover
		WebElement sign = findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span"));

		Actions actions = new Actions(driver);

		actions.moveToElement(sign).click().build().perform();
		
		
		

		findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("kishorekrish742@gmail.com");
		R1.TakeScreenShotAuto(driver, "enterid", "Pass");

		findElement(By.xpath("//*[@id=\"continue\"]")).click();
		R1.TakeScreenShotAuto(driver, "continue", "Pass");

		findElement(By.id("ap_password")).sendKeys("kishore74");
		R1.TakeScreenShotAuto(driver, "enterpass", "Pass");
		
		
        //@java_Script_Executer_click
		WebElement button = findElement(By.xpath("//*[@id=\"signInSubmit\"]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", button);
		js.executeScript("window.scrollBy(0,1000)");
		
		
		

		
		//@Mouse_Hover
		WebElement deliver = findElement(By.xpath("//*[@id=\"nav-global-location-popover-link\"]"));

		actions.moveToElement(deliver).click().build().perform();
		

		WebElement add = findElement(By.xpath("//*[@id=\"GLUXManageAddressLink\"]/a"));
		Thread.sleep(2000);

		actions.moveToElement(add).click().build().perform();

		findElement(By.xpath("//*[@id=\"ya-myab-plus-address-icon\"]")).click();

		findElement(By.xpath("//*[@id=\"address-ui-widgets-countryCode\"]/span/span")).click();
		
		

		// @Dropdown
		Select dropdown1 = new Select(
				findElement(By.xpath("//*[@id=\"address-ui-widgets-countryCode-dropdown-nativeId\"]")));

		dropdown1.selectByValue("AO");
		
		
		
		

		Thread.sleep(2000);

		findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFullName\"]")).sendKeys("kishore");

		findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]")).sendKeys("8008659403");

		findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressLine1\"]")).sendKeys("h:no-4-47");
		
		findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressLine2\"]")).sendKeys("kphb");
		
		findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressCity\"]")).sendKeys("hyd");
		
		findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]")).sendKeys("ts");

		findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPostalCode\"]")).sendKeys("400222");

		findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();

		
		
		
		
		//@Mouse_Hover
		WebElement out = findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
		WebElement bye = findElement(By.xpath(" //*[@id=\"nav-item-signout\"]/span"));

		actions.moveToElement(out).moveToElement(bye).click().build().perform();

	}
    
     
}
