package com.sauceDemo.TestClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sauceDemo.POMClasses.LoginPOMClass;

public class TestBedClass {
	
	WebDriver driver;
	@Parameters("browserName")
	@BeforeMethod
	public void setUp(String browserName)
	{
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\ChromDriver\\chromedriver_win32\\chromedriver.exe");
			 driver=new ChromeDriver();
			
		}
		
		else if(browserName.equals("firefox"))
			
		{
			System.setProperty("webdriver.gecko.driver", "E:\\Geckodriver\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		
		else
		{
			System.out.println("Throw error");
		}

		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		
		//login
		LoginPOMClass lp=new LoginPOMClass(driver);
		lp.sendUsername();
		lp.sendPassword();
		lp.clickloginbutton();
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		System.out.println("end program");
	
	}

	

}
