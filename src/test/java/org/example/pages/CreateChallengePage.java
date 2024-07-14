package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.example.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.File;

import static org.example.utils.ConstantComponent.titleChallenge;

public class CreateChallengePage extends BasePage {
    @FindBy(id = "title")
    private WebElementFacade tbTitle;
    @FindBy(id = "flag")
    private WebElementFacade tbFlag;
    @FindBy(id = "file-upload")
    private WebElementFacade inputFile_upload;
    @FindBy(id = "howtosolve")
    private WebElementFacade tbHowtosolve;
    @FindBy(xpath = "//button[text()='Submit for Verification']")
    private WebElementFacade btnSubmit;

    public void inputTitle(String title) {
        tbTitle.waitUntilVisible().clear();
        tbTitle.sendKeys(title);
    }

    public void inputFlag(String flag) {
        tbFlag.waitUntilVisible().clear();
        tbFlag.sendKeys(flag);
    }

    public void inputFile(String filePath) {
        File file = new File(filePath);
        inputFile_upload.waitUntilVisible().sendKeys(file.getAbsolutePath());
    }

    public void inputHowtosolve(String content) {
        tbHowtosolve.waitUntilVisible().sendKeys(content);
    }

    public void submit() {
        btnSubmit.waitUntilVisible().click();
    }

    public void verifyCreateSuccessfully() {
        Assert.assertTrue(getDriver().findElement(By.xpath(String.format("//span[contains(text(),'%s')]", titleChallenge))).isDisplayed());
    }

    public void checkError(String error) {
        Assert.assertTrue(getDriver().findElement(By.xpath(String.format("//div[@class='invalid-feedback' and text()='%s']", error))).isDisplayed());
    }
}
