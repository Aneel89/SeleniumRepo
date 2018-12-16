package com.maven.project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Test1 {
	
	public class FirstTest {
		WebDriver driver;
		@BeforeMethod
		public void setUp() 
		{
			System.setProperty("webdriver.chrome.driver","C:\\SeleniumBrowsers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			
		}
		@Test
		public void home()
		{
			driver.manage().window().maximize();
		}
		@AfterMethod
		public void exit()
		{
			driver.close();
			//driver.quit();
		}

	}


}
