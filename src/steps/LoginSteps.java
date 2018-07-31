package steps;

import org.openqa.selenium.WebDriver;

import pages.WebForm.LoginPage;

public class LoginSteps {

	LoginPage loginPageObj = new LoginPage();

	public void login(WebDriver driver, String username, String password) {
		loginPageObj.enterUsername(driver, username);
		loginPageObj.enterPassword(driver, password);
		loginPageObj.clickOnSignBtn(driver);
	}

}
