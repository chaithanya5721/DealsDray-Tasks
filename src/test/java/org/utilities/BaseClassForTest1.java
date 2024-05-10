package org.utilities;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassForTest1 {
	public static WebDriver driver;

	public static void chromeBrowserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.getcalley.com/page-sitemap.xml ");
		driver.manage().window().maximize();
	}
	public static void firefoxBrowserLaunch() {
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
			driver.get("https://www.getcalley.com/page-sitemap.xml ");
			driver.manage().window().maximize();

	}
	public static void forTakingScreenshot(String BName) throws IOException
	{
		Date currentDate = new Date();
		String replace = currentDate.toString().replace(" ","-").replace(":", "-");
		
		TakesScreenshot tc = (TakesScreenshot) driver;
		File source = tc.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\CHAITANYA\\Desktop\\Task1\\"+BName+"\\"+replace+".jpeg");
		FileUtils.copyFile(source, target);
	}
	
	public static void forWaitPage() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		}

public static void ForResolution1() {
	
	driver.manage().window().setSize(new Dimension(1920,1080));
}
public static void ForResolution2() {
	
	driver.manage().window().setSize(new Dimension(1366,768));

}
public static void ForResolution3() {
	
	driver.manage().window().setSize(new Dimension(1536,864));

}
}
