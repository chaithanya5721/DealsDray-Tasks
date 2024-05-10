package org.test;

import java.io.File;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utilities.BaseClassForTest2;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 extends BaseClassForTest2 {

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
	public void loginPage() {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		forWaitPage();
	}

	@Parameters({ "browserName" })
	@Test(priority = 2)
	public void OrderImportPage() {
		forWaitPage();
		driver.findElement(By.xpath("(//div[(@class='css-sukebr')]//child::button)[1]")).click();
		driver.findElement(By.xpath("(//div[(@class='expansion-panel submenu')]//child::button)[1]")).click();
		forWaitPage();
		driver.findElement(By.xpath("//button[text()='Add Bulk Orders']")).click();
		forWaitPage();

	}

	@Parameters({ "browserName" })
	@Test(priority = 3)
	public void ImportFile(String bName) throws IOException {
		WebElement upload_file = driver.findElement(By.xpath("//input[@type='file']"));
		upload_file.sendKeys("D:\\Downloads\\Upload\\demo-data.xlsx");
		forWaitPage();
		driver.findElement(By.xpath("//button[text()='Import']")).click();
		forWaitPage();
		driver.findElement(By.xpath("//button[text()='Validate Data']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		a.accept();
		
		forWaitPage();
		
		WebElement element = driver.findElement(By.xpath("//button[text()='Next']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", element);
		forWaitPage();
		
		forTakingScreenshot(bName);
		forWaitPage();
	}

	@Parameters({ "browserName" })
	@Test(priority = 4)
	public void loginPage1() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a1 = driver.switchTo().alert();
		forWaitPage();
		a1.accept();
		
		driver.quit();
	}

}
