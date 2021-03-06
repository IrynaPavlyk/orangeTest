package com.orange.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Browser {

	public static WebDriver open() {
		System.setProperty("webdriver.chrome.driver", "C:\\library\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver;
		String browserName = System.getProperty("browser");
		if (browserName == null || "chrome".equals(browserName))
			return startChromeDriver();
		else if ("firefox".equals(browserName))
			return startFirefoxDriver();
		throw new RuntimeException("Unsupported browser: " + browserName);
	}

	private static WebDriver startChromeDriver() {
		return new ChromeDriver();
	}

	private static WebDriver startFirefoxDriver() {
		return new FirefoxDriver();
	}

}

