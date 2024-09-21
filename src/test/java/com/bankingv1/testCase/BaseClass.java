package com.bankingv1.testCase;

import com.bankingv1.utilites.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	
	public String baseURL = readConfig.getApplicationURL();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if (browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", readConfig.getChromepath());
			driver = new ChromeDriver();
		}else if (browser.equals("firefox")){
			System.setProperty("webdriver.chrome.driver", readConfig.getFirefoxpath());
			driver = new FirefoxDriver();
		}else if (browser.equals("ie")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getIepath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public void captureScreen(WebDriver driver,String tname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir")+"/screenshorts/"+tname+".png");
		FileUtils.copyFile(src,trg);
		System.out.println("screenshot taken");

	}
	public String randomString(){
		String generatestring = RandomStringUtils.randomAlphabetic(8);
		return generatestring;
	}
	public static String randomNum(){
		String generatestring = RandomStringUtils.randomAlphanumeric(4);
		return generatestring;
	}

}
