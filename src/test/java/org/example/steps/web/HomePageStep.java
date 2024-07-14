package org.example.steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;

public class HomePageStep {
    HomePage homePage = new HomePage();

    @And("Go to {string} Page")
    public void goToPage(String page) {
        homePage.clickChallengesButton();
        if (page.contains("Create A Challenge")) {
            homePage.clickCreateChallengeButton();
        } else if (page.contains("My Challenge")) {
            homePage.clickMyChallengeButton();
        }
    }

    @When("Click on the logout button")
    public void clickLogoutButton() {
        homePage.clickIconProfile();
        homePage.clickLogoutButton();
    }
}
