package com.orange.test;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.support.ui.WebDriverWait;

import static com.orange.data.UserData.ADMIN_USER;
import static com.orange.data.UserData.ESS_USER;

import org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.orange.data.User;

import ru.yandex.qatools.allure.annotations.Step;

import com.orange.app.OrangeDashboardPage;
import com.orange.app.OrangeHRM;
import com.orange.app.SaveSystemUsersPage;
import com.orange.app.SystemUsersPage;

public class LoginTest {

	private OrangeDashboardPage onOrangeDashboardPage;
	private SystemUsersPage onSystemUsersPage;
	private SaveSystemUsersPage onSaveSystemUsersPage;
	
	
	
		@Test(dataProvider = "testData")
		public void testIfUserIsAbleToLogin(User user) {
			onOrangeDashboardPage = OrangeHRM.openHomePage().loginAs(user);
			
			assertEquals(onOrangeDashboardPage.getCurrentUrl(), "http://opensource.demo.orangehrmlive.com/index.php/dashboard",
					"Incorrect URL after login");

			String actualText = onOrangeDashboardPage.getTextWithUserName();
			String expectedText = "Welcome " + user.getName();

			assertEquals(actualText, expectedText, "Name of " + user + "in the message is not correct");
		}


		@DataProvider(name = "testData")
		public static Object[][] testData() {
			return new Object[][] { { ADMIN_USER }, { ESS_USER } };
		}
		@Test(dependsOnMethods = "testIfUserIsAbleToLogin")
		public void testAddNewUser() {
			private WebDriver driver;
			onSystemUsersPage = onOrangeDashboardPage.clickOnAdminTab();
			new WebDriverWait(driver, 10).until(
					urlToBe("http://opensource.demo.orangehrmlive.com/index.php/admin/viewSystemUsers"));
			int a = onSystemUsersPage.getSizebefore();
			onSaveSystemUsersPage = onSystemUsersPage.clickAddButton();
			new WebDriverWait(driver, 10).until(
					urlToBe("http://opensource.demo.orangehrmlive.com/index.php/admin/viewSystemUsers"));
			onSaveSystemUsersPage.selectUserRole(2);
			onSaveSystemUsersPage.fillEmployeeName();
			onSaveSystemUsersPage.fillUserName();
			onSaveSystemUsersPage.selectUserStatus(1);
			onSaveSystemUsersPage.fillUserPassword();
			onSaveSystemUsersPage.confirmUserPassword();
			onSystemUsersPage = onSaveSystemUsersPage.clickSaveButton();
			int b = onSystemUsersPage.getSizeafter();
			int diff = b - a;
			assertTrue(diff == 1);
			
			
			
		}
		
		@AfterMethod(alwaysRun = true)
		public void tearDown() {
			OrangeHRM.close();
		}
		
	
	}

