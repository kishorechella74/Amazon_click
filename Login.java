package kishore;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;

import Day_018_Waits.Reporter1;
import ExcelUtil.ExcelApiTest4;
import Reporter_Example_Word.ImageAttachmentInDocument1;
import Reporter_Example_Word.WordConvertPDF;

public class Login {

	WebDriver driver;
	
	
	static Reporter1 R1;
	
	
	public  void Login(WebDriver driver) 
	{
		this.driver = driver;

	}
	
	


	
	public void login() throws Exception
	
	{
		
//		ImageAttachmentInDocument1 IA = new ImageAttachmentInDocument1();
//		IA.CreateHeader("Amazon Status Report");
//		
//		SimpleDateFormat sdfDate1 = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_a");
//		Date now1 = new Date();
//		String strDate1 = sdfDate1.format(now1);
//		String TestName="Login_log"+strDate1;
		
		String str = "Amazon_click";
		R1 = new Reporter1(driver, "Amazon_click");
	
	//@Mouse_Hover
	WebElement sign = findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span"));

	Actions actions = new Actions(driver);

	actions.moveToElement(sign).click().build().perform();

	findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("kishorekrish742@gmail.com");
//	 String strr=R1.getScreenShotPath(driver);
//	    IA.PasteImage("Pass- open Amazon",strr);

	findElement(By.xpath("//*[@id=\"continue\"]")).click();
	R1.TakeScreenShotAuto(driver, "continue", "Pass");

	findElement(By.id("ap_password")).sendKeys("kishore74");
	R1.TakeScreenShotAuto(driver, "enterpass", "Pass");
	
	
    //@java_Script_Executer_click
	WebElement button = findElement(By.xpath("//*[@id=\"signInSubmit\"]"));

	JavascriptExecutor js = (JavascriptExecutor) driver;

	js.executeScript("arguments[0].click();", button);
	js.executeScript("window.scrollBy(0,1000)");
	
//    String Filename=IA.WordOutput_File(TestName);
//    WordConvertPDF.main(Filename);
	
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
