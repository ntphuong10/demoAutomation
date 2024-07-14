package org.example.base;

import io.cucumber.java.BeforeAll;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Before;

import static org.example.utils.EnvironmentConfig.URL_WEB;

public class BasePage extends PageObject {
    @Before
    public void openTheApplication() {
        System.out.println("aaaaa");    }
}
