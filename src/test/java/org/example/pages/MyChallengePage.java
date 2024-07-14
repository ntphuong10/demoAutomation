package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.example.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MyChallengePage extends BasePage {
    public void verifyChallengeExist(String text) {
        Assert.assertTrue(getDriver().findElement(By.xpath(String.format("//span[text()='%s']", text))).isDisplayed());
    }
}
