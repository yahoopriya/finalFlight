package Demo.demo.epam.com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MyTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.cleartrip.com/");
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(""));
		
		// for Eneter
		act.sendKeys(Keys.RETURN);
		
		//taking screenshots as below;
		
		TakesScreenshot tc = (TakesScreenshot)driver;
		File file1 = tc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1, new File("./test.jpg"));
		
		//for Switching to the default window
		
		driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		driver.switchTo().window("");
		Alert al =driver.switchTo().alert();
		al.accept();
		al.dismiss();
		al.sendKeys("fdhgfsadhg");
		//al.authenticateUsing();
		al.getText();
		//al.setCredentials(credentials);
		
		//for Right
		act.contextClick();
		act.contextClick(element);
		act.moveToElement(element).moveToElement(element).build().perform();
		
		
	}

}
