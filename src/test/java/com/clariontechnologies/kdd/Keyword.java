package com.clariontechnologies.kdd;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.clariontechnologies.utils.WebDriverInstance;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.log4testng.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {
	private static Logger log = Logger.getLogger(Keyword.class);

	public static void launchUrl(String url) {
		log.info("Web Site Url" + url);
		WebDriverInstance.INSTANCE.getDriver().get(url);
	}

	public static void maximizeWindow() {
		WebDriverInstance.INSTANCE.getDriver().manage().window().maximize();
	}

	public static void pageRefresh() {
		WebDriverInstance.INSTANCE.getDriver().navigate().refresh();
	}

	public static void closebrowser() {
		WebDriverInstance.INSTANCE.getDriver().close();
	}

	public static void explicitWait(int duration) {
		Wait<WebDriver> wait = new FluentWait(WebDriverInstance.INSTANCE.getDriver())

				.withTimeout(duration, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
	}

	public static void selectdropdown(WebElement webelement, String value) {
		Select select = new Select(webelement);
		select.selectByVisibleText(value);
	}

	/**
	 *
	 * @param testCaseName
	 * @param driver1
	 * @return screenshot path
	 */
	public String takeScreenShot(String testCaseName, WebDriver driver1) {
		File src = ((TakesScreenshot) WebDriverInstance.INSTANCE.getDriver()).getScreenshotAs(OutputType.FILE);

		String today = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
		String des = System.getProperty("user.dir") + "\\reports\\" + testCaseName + "_" + today + ".JPG";
		try {
			FileUtils.copyFile(src, new File(des));

		} catch (IOException e) {
			System.err.println("File Not created");
			e.printStackTrace();
		}
		return des;

	}
}
