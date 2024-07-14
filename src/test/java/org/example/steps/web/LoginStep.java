package org.example.steps.web;

import io.cucumber.java.en.Given;
import org.example.pages.LoginPage;
import static org.example.utils.EnvironmentConfig.URL_WEB;

public class LoginStep {
    LoginPage loginPage = new LoginPage();

    @Given("^Click login button$")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Given("^Login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void enterUserAndPassword(String username, String password) {
        loginPage.enterUserAndPassword(username, password);
    }

    @Given("^Go to website$")
    public void goToWebsite() {
        loginPage.goToWebsite(URL_WEB);
    }


}
