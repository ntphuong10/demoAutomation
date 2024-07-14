package org.example.utils;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class EnvironmentConfig {
    public static EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();

    public static final String URL_WEB = EnvironmentSpecificConfiguration.from(env)
            .getProperty("urlWeb");
    public static final String URL_API = EnvironmentSpecificConfiguration.from(env)
            .getProperty("urlAPI");
}
