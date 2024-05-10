package org.test;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.utilities.BaseClassForTest1;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 extends BaseClassForTest1 {

	@BeforeTest
	@Parameters({ "browserName" })
	public void LaunchBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			chromeBrowserLaunch();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			firefoxBrowserLaunch();
		}
	}

	@Parameters({ "browserName" })
	@Test(priority = 1)
	public void tc1(String bName) throws InterruptedException, IOException {
		WebElement element = driver.findElement(By.linkText("https://www.getcalley.com/"));
		element.click();
		forWaitPage();
		ForResolution1();
		forTakingScreenshot(bName);
		forWaitPage();
		ForResolution2();
		forTakingScreenshot(bName);
		forWaitPage();
		ForResolution3();
		forTakingScreenshot(bName);
		forWaitPage();
		driver.navigate().back();
		forWaitPage();
	}

	@Parameters({ "browserName" })
	@Test(priority = 2)
	public void tc2(String bName) throws InterruptedException, IOException {
		driver.findElement(By.partialLinkText("https://www.getcalley.com/calley-call-from-browser/")).click();
		ForResolution1();
		forTakingScreenshot(bName);
		forWaitPage();
		ForResolution2();
		forTakingScreenshot(bName);
		forWaitPage();
		ForResolution3();
		forTakingScreenshot(bName);
		forWaitPage();
		driver.navigate().back();
		forWaitPage();
	}

	@Parameters({ "browserName" })
	@Test(priority = 3)
	public void tc3(String bName) throws IOException, InterruptedException {
		driver.findElement(By.linkText("https://www.getcalley.com/calley-pro-features/")).click();
		ForResolution1();
		forTakingScreenshot(bName);
		forWaitPage();
		ForResolution2();
		forTakingScreenshot(bName);
		forWaitPage();
		ForResolution3();
		forTakingScreenshot(bName);
		forWaitPage();
		driver.navigate().back();
		forWaitPage();
	}

	@Parameters({ "browserName" })
	@Test(priority = 4)
	public void tc4(String bName) throws InterruptedException, IOException {
		driver.findElement(By.partialLinkText("https://www.getcalley.com/best-auto-dialer-app/")).click();
		ForResolution1();
		forTakingScreenshot(bName);
		forWaitPage();
		ForResolution2();
		forTakingScreenshot(bName);
		forWaitPage();
		ForResolution3();
		forTakingScreenshot(bName);
		forWaitPage();
		driver.navigate().back();
		forWaitPage();
	}

	@Parameters({ "browserName" })
	@Test(priority = 5)
	public void tc5(String bName) throws InterruptedException, IOException {
		driver.findElement(By.linkText("https://www.getcalley.com/how-calley-auto-dialer-app-works/")).click();
		ForResolution1();
		forTakingScreenshot(bName);
		forWaitPage();
		ForResolution2();
		forTakingScreenshot(bName);
		forWaitPage();
		ForResolution3();
		forTakingScreenshot(bName);
		forWaitPage();
		driver.navigate().back();
		forWaitPage();
		driver.quit();
	}

}
