package com.parameters.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	@Parameters({"browser","url","email"})
	@Test
	public void login(String browser,String url,String email) 
	{
		if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","C:\\SeleniumBrowsers\\chromedriver.exe");
		driver=new ChromeDriver();
		}else if(browser.equals("Firefox"))
		{
		System.setProperty("webdriver.gecko.driver","C:\\SeleniumBrowsers\\geckodriver.exe");
		driver=new FirefoxDriver();
		}
		driver.get(url);
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='login-signin']")).click();
}
}
