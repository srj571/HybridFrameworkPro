package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	public static Logger logger =LogManager.getLogger(BaseClass.class.getName());

	ReadConfig rc=new ReadConfig();
	
	public String baseURL=rc.getApplicationUrl();
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	public static WebDriver driver;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {	
		if(br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", rc.getChromePath());
//			ChromeOptions options = new ChromeOptions();
//	        options.addArguments("--headless");
//	        options.addArguments("--disable-gpu");
//			driver=new ChromeDriver(options);
			driver=new ChromeDriver();
			
			
		}
		else if(br.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", rc.getMsEdgePath());
			driver=new EdgeDriver();
		}	
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(System.getProperty("user.dir")+"./Screenshots/"+ tname + ".png");
		FileUtils.copyFile(src, trg);
		System.out.println("Screenshot taken");		
	}	
	public static String getRandomString() {
		String email=RandomStringUtils.randomAlphabetic(5);
		return email;
	}
	public static String getRandomNum() {
		String email=RandomStringUtils.randomNumeric(10);
		return email;
	}
	
	
	
	
	
	
	
}
