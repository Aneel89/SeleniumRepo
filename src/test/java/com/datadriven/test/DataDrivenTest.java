package com.datadriven.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excel.util.Xls_Reader;

public class DataDrivenTest {
	WebDriver driver;
	@BeforeTest
	//Launching webdriver and URL
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","C:\\SeleniumBrowsers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void register()
	{
		//Getting data from excel sheet
		Xls_Reader reader=new Xls_Reader("C:\\Users\\AneelPC\\eclipse-workspace\\MavenSeleniumProject\\src\\test\\java\\com\\testdata\\RegTestData.xlsx");
		int rowcnt=reader.getRowCount("RegTestData");
		System.out.println(rowcnt);
		reader.addColumn("RegTestData", "Status");
		//Parameterization
		for(int rownum=2;rownum<=rowcnt;rownum++)
		{
			System.out.println("===========");
			String Firstname=reader.getCellData("RegTestData","Firstname", rownum);
			System.out.println(Firstname);
			String Lastname=reader.getCellData("RegTestData","Lastname", rownum);
			System.out.println(Lastname);
			String Address=reader.getCellData("RegTestData","Address", rownum);
			System.out.println(Address);
			String Emailaddress=reader.getCellData("RegTestData","Emailaddress", rownum);
			System.out.println(Emailaddress);
			
			driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[1]/input")).clear();
			driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[1]/input")).sendKeys(Firstname);
			driver.findElement(By.xpath("//*[@id=\'basicBootstrapForm\']/div[1]/div[2]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\'basicBootstrapForm\']/div[1]/div[2]/input")).sendKeys(Lastname);
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).clear();
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys(Address);
			driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys(Emailaddress);
			reader.setCellData("RegTestData","Status",rownum,"Pass");
			//pulled the code
		}	
	}	
}
