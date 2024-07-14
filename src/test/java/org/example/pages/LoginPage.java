package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.example.base.BasePage;


public class LoginPage extends BasePage {
    @FindBy(xpath = "//a[text()='Login']")
    private WebElementFacade btnLogin;
    @FindBy(name = "identifier")
    private WebElementFacade txtUsername;
    @FindBy(name = "password")
    private WebElementFacade txtPassword;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade btnLoginSubmit;

    public void goToWebsite(String url) {
        openUrl(url);
        getDriver().manage().window().maximize();
    }

    public void clickLoginButton() {
        btnLogin.waitUntilVisible().click();
    }

    public void enterUserAndPassword(String username, String password) {
        txtUsername.waitUntilVisible().sendKeys(username);
        txtPassword.waitUntilVisible().sendKeys(password);
        btnLoginSubmit.waitUntilVisible().click();
    }
}
