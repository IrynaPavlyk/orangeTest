package com.orange.app;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.orange.app.SaveSystemUsersPage;
import ru.yandex.qatools.allure.annotations.Step;

public class SystemUsersPage {

	@FindBy(id = "btnAdd")
	private WebElement addButton;

	private WebDriver driver;

	public SystemUsersPage(WebDriver driver) {
		this.driver = driver;
		new WebDriverWait(driver, 10).until(urlToBe("http://opensource.demo.orangehrmlive.com/index.php/admin/viewSystemUsers"));
		PageFactory.initElements(driver, this);
	}

	@Step("Click on 'Add' button")
	public SaveSystemUsersPage clickAddButton() {
		addButton.click();
		return new SaveSystemUsersPage(driver);
	}

}
