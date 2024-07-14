package org.example.steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.CreateChallengePage;
import org.example.pages.MyChallengePage;
import org.example.utils.Helper;

import static org.example.utils.ConstantComponent.titleChallenge;
import static org.example.utils.FilePath.FileUploadCreateChallenge;

public class MyChallengeStep {
    MyChallengePage myChallengePage = new MyChallengePage();

    @And("A Challenge just created displays")
    public void verifyChallengeExist() {
        myChallengePage.verifyChallengeExist(titleChallenge);
    }
}
