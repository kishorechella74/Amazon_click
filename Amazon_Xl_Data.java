package kishore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import August_13_DataProvider.TC01_Skills_Excel;
import Day_018_Waits.Reporter1;
import ExcelUtil.ExcelApiTest4;

public class Amazon_Xl_Data  {
	
	static WebDriver driver;
	static Reporter1 R1;
	
	//Step1
	//String TestURL="https://opensource-demo.orangehrmlive.com/";
	//String UserName="Admin",Password="admin123";
	//String SkillName="Java12",SkillDescr="Java12 descr";
	
	@DataProvider(name = "log")
	public static Object[][] Authentication1() throws Exception {
		Object[][] testObjArray = null;
		try {
		ExcelApiTest4 eat = new ExcelApiTest4();
		//Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Skills_13.xlsx", "Sheet1");
		testObjArray = eat.getTableArray("C:\\kishore\\excel74\\Book1.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured in authentication " + e.getMessage());
		}
		return (testObjArray);
	}
	
	
	
	@Test(dataProvider="log")//Step2
	public void loginTest(String TestURL,String UserName,String Password) throws Exception//Step3
	{

		//TC01_Skills_Excel T1 = new TC01_Skills_Excel();
		
		OpenChromeBroswer(TestURL);
		Login(UserName,Password);
		
		CloseBrowser();
	}
	
	
	public void OpenChromeBroswer(String TestURL1) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.get(TestURL1);
	}
	

	

	public void Login(String UserName1,String Password1) throws Exception
	{
		try {
		String str = "Amazon_Demo";
		R1 = new Reporter1(driver, str);
		
//		//@Mouse_Hover
//		WebElement sign = findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span"));
//
//		Actions actions = new Actions(driver);
//
//		actions.moveToElement(sign).click().build().perform();
		System.out.println("before css selector");
		findElement(By.id("nav-link-accountList")).click();
		System.out.println("after css selector");
		findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(UserName1);
		R1.TakeScreenShotAuto(driver, "enterid", "Pass");

		findElement(By.xpath("//*[@id=\"continue\"]")).click();
		R1.TakeScreenShotAuto(driver, "continue", "Pass");

		findElement(By.id("ap_password")).sendKeys(Password1);
		R1.TakeScreenShotAuto(driver, "enterpass", "Pass");
		
		
	    //@java_Script_Executer_click
		WebElement button = findElement(By.xpath("//*[@id=\"signInSubmit\"]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", button);
		js.executeScript("window.scrollBy(0,1000)");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Exception found : " + e.getMessage());
		}
	}
	

	
	

	public void CloseBrowser() throws Exception
	{
		driver.quit();
	}
	

	
	
	
	
	public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}

	

}

