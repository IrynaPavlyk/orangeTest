package com.orange.app;

import org.openqa.selenium.WebDriver;
import com.orange.tools.*;
import ru.yandex.qatools.allure.annotations.Step;

public class OrangeHRM {

		private static final String BASE_URL = "http://opensource.demo.orangehrmlive.com/";
		private static WebDriver driver;

		@Step("Open Home Page by URL: " + BASE_URL)
		public static HomePage openHomePage() {
			driver = Browser.open();
			driver.get(BASE_URL);
			return new HomePage(driver);
		}
		

		@Step("Close Browser")
		public static void close() {
			if (driver != null)
				driver.close();
			driver = null;
		}
		
	}

