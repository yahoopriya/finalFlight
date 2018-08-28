/**
 * 
 */
package com.epam.cleartrip.suitbase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.epam.cleartrip.utility.JsonDataReader;
import com.epam.cleartrip.utility.PropertyFileReader;
import com.epam.cleartrip.utility.RestUtil;

import cucumber.api.java.Before;

public class BaseUtilityClearTrip {
    
	protected static WebDriver driver = null;
	public Actions act = null;
	public static JsonDataReader jsonreader = null;
	public static PropertyFileReader propertyloader = null;
	public static RestUtil restutil = null;
	
	@BeforeSuite
	public static void loadJsonData() throws IOException {		
		 new JsonDataReader().loadDatafromjson();	
		  propertyloader = new PropertyFileReader();
		  propertyloader.propertyFileLoader();
		  restutil = new RestUtil();
	}
	
  
	   
	@Parameters({ "browserType" })
	@BeforeTest	
	public void selectBrowser(String browserType) {		
		switch (browserType) {
		
		case "firefox":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.cleartrip.com/");
			act = new Actions(driver);
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\E\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(propertyloader.property.getProperty("URL"));
			Assert.assertEquals(restutil.verifyresponse(), 200);
			act = new Actions(driver);
			break;

		case "ie":
			System.setProperty("webdriver.chrome.driver", "D:\\E\\chromedriver_win32\\chromedriver.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.cleartrip.com/");
			act = new Actions(driver);
			break;

		}
	}

	@AfterSuite
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				Reporter.log("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				Reporter.log("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			Reporter.log("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			Reporter.log("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			Reporter.log("Unable to click on element "+ e.getStackTrace());
		}
	}
   
}
