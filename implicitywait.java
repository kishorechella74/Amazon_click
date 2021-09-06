package kishore;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import Day_018_Waits.Reporter1;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class implicitywait {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

 



@Test
public void name() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\venka\\Downloads\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	String str = "TC01_Login";
	R1 = new Reporter1(driver, str);

	String TestURL = "https://www.amazon.in/?ie=UTF8&ext_vrnc=hi&tag=googhydrabk-21&ascsubtag=_k_CjwKCAjwgviIBhBkEiwA10D2jwla8RMPgslMnd2TWS241T1koJXmlTH9Dq_QumZ2USiTw1X4yF_SkhoCf40QAvD_BwE_k_&ext_vrnc=hi&gclid=CjwKCAjwgviIBhBkEiwA10D2jwla8RMPgslMnd2TWS241T1koJXmlTH9Dq_QumZ2USiTw1X4yF_SkhoCf40QAvD_BwE";
	driver.get(TestURL);
	R1.TakeScreenShotAuto(driver, "openamazon", "Pass");

	Thread.sleep(1000);

	
	WebElement sign = findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span"));

	Actions actions = new Actions(driver);

	actions.moveToElement(sign).click().build().perform();

	findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("kishorekrish742@gmail.com");
	R1.TakeScreenShotAuto(driver, "enterid", "Pass");

	findElement(By.xpath("//*[@id=\"continue\"]")).click();
	R1.TakeScreenShotAuto(driver, "continue", "Pass");

	findElement(By.id("ap_password")).sendKeys("kishore74");
	R1.TakeScreenShotAuto(driver, "enterpass", "Pass");

	WebElement button = findElement(By.xpath("//*[@id=\"signInSubmit\"]"));

	JavascriptExecutor js = (JavascriptExecutor) driver;

	js.executeScript("arguments[0].click();", button);
	js.executeScript("window.scrollBy(0,1000)");

	WebElement deliver = findElement(By.xpath("//*[@id=\"nav-global-location-popover-link\"]"));
	
	actions.moveToElement(deliver).click().build().perform();
	
	
	WebElement add=findElement(By.xpath("//*[@id=\"GLUXManageAddressLink\"]/a"));
	
	actions.moveToElement(add).click().build().perform();
	
	findElement(By.xpath("//*[@id=\"ya-myab-plus-address-icon\"]")).click();
	
	
	
	findElement(By.xpath("//*[@id=\"address-ui-widgets-countryCode\"]/span/span")).click();

	
	Select dropdown1 = new Select(findElement(By.xpath("//*[@id=\"address-ui-widgets-countryCode-dropdown-nativeId_3\"]")));
	dropdown1.selectByValue("IS");
	
	
	
	
	
	
	findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFullName\"]")).sendKeys("kishore");
	
	
	findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]")).sendKeys("8008659403");
	findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPostalCode\"]")).sendKeys("400222");
	findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressLine1\"]")).sendKeys("h:no-4-47,kphb");
	findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressLine2\"]")).sendKeys("hyd,ts");
	findElement(By.xpath("//*[@id=\"address-ui-widgets-landmark\"]")).sendKeys("roadno-2");	
	findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressCity\"]")).sendKeys("hyd");	
	
	//Select dropdown1 = new Select(findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]/span/span")));
	//		dropdown1.selectByVisibleText("ANDHRA PRADESH");
	
	
	
	
	//WebElement out = findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
	//WebElement bye = findElement(By.xpath(" //*[@id=\"nav-item-signout\"]/span"));

//	actions.moveToElement(out).moveToElement(bye).click().build().perform();

