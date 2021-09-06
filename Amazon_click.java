package kishore;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import Day_029_PageObjectModel.HomePage;
import Day_029_PageObjectModel.LoginPage;
import Day_029_PageObjectModel.Nationalities;


public class Amazon_click {


		WebDriver driver;
		
		@BeforeTest 
		public void  TestSetup()throws Exception {
			
			driver = TestBrowser.OpenChromeBrowser();
			String TestURL = "https://www.amazon.in/?ie=UTF8&ext_vrnc=hi&tag=googhydrabk-21&ascsubtag=_k_CjwKCAjwgviIBhBkEiwA10D2jwla8RMPgslMnd2TWS241T1koJXmlTH9Dq_QumZ2USiTw1X4yF_SkhoCf40QAvD_BwE_k_&ext_vrnc=hi&gclid=CjwKCAjwgviIBhBkEiwA10D2jwla8RMPgslMnd2TWS241T1koJXmlTH9Dq_QumZ2USiTw1X4yF_SkhoCf40QAvD_BwE";
			driver.get(TestURL);

	}

		@Test
		public void Book_OneWay_Flight() throws Exception {
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			
			
			//below line opens new tab
			((JavascriptExecutor)driver).executeScript("window.open()");
			

			//strore all the open windows in ArrayList string
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
			

		
			//back to MainWindow
			driver.switchTo().window(tabs.get(0));
			
			
		
			
			
			Login L2 = new Login();
			L2.Login(driver);
			L2.login();
			
			
			
			Adderss A1= new Adderss();
			A1.Address(driver);
			A1.AddAddress();
			
			Order O1= new Order();
			O1.Order(driver);
			O1.Order();
			

			
			Logout l1= new Logout();
			l1.Logout(driver);
			l1.logout();
			
			
			
			
			//Switch to New tab
			driver.switchTo().window(tabs.get(1));
			driver.get("http://google.com");
			
			String TestURL = "https://www.amazon.in/?ie=UTF8&ext_vrnc=hi&tag=googhydrabk-21&ascsubtag=_k_CjwKCAjwgviIBhBkEiwA10D2jwla8RMPgslMnd2TWS241T1koJXmlTH9Dq_QumZ2USiTw1X4yF_SkhoCf40QAvD_BwE_k_&ext_vrnc=hi&gclid=CjwKCAjwgviIBhBkEiwA10D2jwla8RMPgslMnd2TWS241T1koJXmlTH9Dq_QumZ2USiTw1X4yF_SkhoCf40QAvD_BwE";
			driver.get(TestURL);
			
			Login L1 = new Login();
			L1.Login(driver);
			L1.login();
			
			Logout l2= new Logout();
			l2.Logout(driver);
			l2.logout();
			
			
		}
		
		@AfterTest 
		public void  TestCloser()throws Exception {	
			driver.quit();
		
		
		
		
		}	
}
