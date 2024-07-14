package org.example.steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.CreateChallengePage;
import org.example.utils.Helper;

import static org.example.utils.ConstantComponent.titleChallenge;
import static org.example.utils.FilePath.FileUploadCreateChallenge;

public class CreateChallengeStep {
    CreateChallengePage createChallengePage = new CreateChallengePage();
    Helper helper = new Helper();

    @And("Input title {string}, flag {string}, file {string} and how to solve {string}")
    public void inputTitleFlagFileAndHowToSolve(String title, String flag, String file, String content) {
        titleChallenge = title + helper.convertDateToInt();
        createChallengePage.inputTitle(titleChallenge);
        createChallengePage.inputFlag("CTFlearn{" + flag + helper.convertDateToInt() + "}");
        createChallengePage.inputFile(FileUploadCreateChallenge);
        createChallengePage.inputHowtosolve(content + helper.convertDateToInt());
    }

    @And("Click submit button and check error {string} if exist")
    public void clickSubmitButtonAndCheckErrorIfExist(String error) {
        createChallengePage.submit();
        if (!error.isEmpty()) {
            createChallengePage.checkError(error);
        }else{
            createChallengePage.verifyCreateSuccessfully();
        }
    }
}
