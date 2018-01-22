package com.orange.app;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.orange.data.User;
import com.orange.app.OrangeDashboardPage;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage {
	@FindBy(id = "txtUsername")
	private WebElement FieldName;

	@FindBy(id = "txtPassword")
	private WebElement FieldPassword;

	@FindBy(id = "btnLogin")
	private WebElement LoginButton;

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		new WebDriverWait(driver, 10).until(urlToBe("http://www.practiceselenium.com/welcome.html"));
		PageFactory.initElements(driver, this);
	}

	@Step("Fill User name Field with value <{0}>")
	public void fillUsernameField(String name) {
		FieldName.sendKeys(name);
	}

	@Step("Fill Password Field with value <{0}>")
	public void fillPasswordField(String password) {
		FieldPassword.sendKeys(password);
	}

	@Step("Click on the 'Login' button on home page ")
	public void clickLoginButton() {
		LoginButton.click();
	}
	
	@Step("Login as <{0}>")
	public OrangeDashboardPage loginAs(User user) {
		fillUsernameField(user.getName());
		fillPasswordField(user.getPassword());
		clickLoginButton();
		return new OrangeDashboardPage(driver);
	}
	@Step("Read current URL")
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

}


