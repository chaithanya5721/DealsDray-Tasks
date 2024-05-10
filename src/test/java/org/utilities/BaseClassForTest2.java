package org.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassForTest2 {
	
	public static WebDriver driver;

	public static void chromeBrowserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.dealsdray.com/");
		driver.manage().window().maximize();
	}
	public static void firefoxBrowserLaunch() {
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
			driver.get("https://demo.dealsdray.com/");
			driver.manage().window().maximize();

	}
	
	public static void forTakingScreenshot(String BName) throws IOException
	{
		Date currentDate = new Date();
		String replace = currentDate.toString().replace(" ","-").replace(":", "-");
		
		TakesScreenshot tc = (TakesScreenshot) driver;
		File source = tc.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\CHAITANYA\\Desktop\\Task2\\"+BName+"\\"+replace+".jpeg");
		FileUtils.copyFile(source, target);
	}
	
	public static void forWaitPage()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

}
