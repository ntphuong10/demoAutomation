package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.example.base.BasePage;

public class HomePage extends BasePage {
    @FindBy(xpath = "//a[@id='navbarDropdownMenuLink']//following-sibling::a")
    private WebElementFacade btnChallenges;
    @FindBy(xpath = "//*[@aria-labelledby='navbarDropdownMenuLink']/a[text()='Create Challenge']")
    private WebElementFacade btnCreateChallenge;
    @FindBy(xpath = "//*[@aria-labelledby='navbarDropdownMenuLink']//a[contains(text(),'My')]")
    private WebElementFacade btnMyChallenge;
    @FindBy(id = "profileDropdown")
    private WebElementFacade btnProfile;
    @FindBy(xpath = "//div[@aria-labelledby='profileDropdown']//a//i[contains(@class,'sign-out')]")
    private WebElementFacade btnLogout;

    public void clickChallengesButton() {
        btnChallenges.waitUntilVisible().click();
    }

    public void clickCreateChallengeButton() {
        btnCreateChallenge.waitUntilVisible().click();
    }

    public void clickMyChallengeButton() {
        btnMyChallenge.waitUntilVisible().click();
    }

    public void clickIconProfile() {
        btnProfile.waitUntilVisible().click();
    }

    public void clickLogoutButton() {
        btnLogout.waitUntilVisible().click();
    }
}
