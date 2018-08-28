package com.epam.cleartrip.suitbase;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AbstractSuitSteps extends BaseUtilityClearTrip {

	public static String getCurrentdate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		return dateFormat.format(date);
	}

	public static void checkBoxCheck(WebElement element) {
		element.click();
	}

	public static void clickOnBtton(WebElement element) {
		element.click();
	}
	
	public static void waitFor(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void scrollToElement() {
		JavascriptExecutor javascriptobj = (JavascriptExecutor) driver;
		javascriptobj.executeScript("scroll(0, 1000);");
	}

	public static boolean isEnabledElement(WebElement element) {
		if (element.isEnabled()) {
			Reporter.log(" element is enabled");
			return true;
		} else {
			Reporter.log("element is not enabled");
			return false;
		}
	}

	public static boolean isDisplayedElement(WebElement element) {
		if (element.isDisplayed()) {
			Reporter.log(" element is Displayed");
			return true;
		} else {
			Reporter.log("element is not Displayed");
			return false;
		}
	}
	
	public static void waitForElementToBeEnabled(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void insertText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public static void selectOptions(String count, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(count);
	}
	
	public static void fluintWait(WebElement element) throws IOException {
		Actions action = new Actions(driver);
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File s = screenShot.getScreenshotAs(OutputType.FILE);
		BufferedImage image = ImageIO.read(s);
		
		Select select = new Select(element);
		
	}
}