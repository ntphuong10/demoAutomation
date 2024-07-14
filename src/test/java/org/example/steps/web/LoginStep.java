package org.example.steps.web;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import static org.example.utils.EnvironmentConfig.URL_WEB;

public class LoginStep {
    LoginPage loginPage = new LoginPage();

    @Given("^I click on the login button$")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Given("^I can login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void enterUserAndPassword(String username, String password) {
        loginPage.enterUserAndPassword(username, password);
    }

    @Given("^Go to the website$")
    public void goToWebsite() {
        loginPage.goToWebsite(URL_WEB);
    }
}
