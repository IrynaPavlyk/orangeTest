package com.orange.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SaveSystemUsersPage {
	
	@FindBy(id = "systemUser_userType")
	private WebElement UserRole;
	
	@FindBy(id = "systemUser_employeeName_empName")
	private WebElement EmployeeName;
	
	@FindBy(id = "systemUser_userName")
	private WebElement UserName;
	
	@FindBy(id = "systemUser_status")
	private WebElement UserStatus;
	
	@FindBy(id = "systemUser_password")
	private WebElement Password;
	
	@FindBy(id = "systemUser_confirmPassword")
	private WebElement ConfirmPassword;

	private WebDriver driver;

	public SaveSystemUsersPage(WebDriver driver) {
		
	}

}
