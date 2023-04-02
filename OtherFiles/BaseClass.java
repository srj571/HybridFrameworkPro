package com.clearTrip.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.clearTrip.utilities.ReadConfig;

public class BaseClass {
	public static Logger logger =LogManager.getLogger(BaseClass.class.getName());
	ReadConfig rc = new ReadConfig();
	public static WebDriver driver;
	public String baseURL = rc.getApplicationUrl();

	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		if (br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", rc.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", rc.getMsEdgePath());
			driver = new EdgeDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
