package pages;

import util.properties.EnvironmentProperties;

import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    public BasePage() {
    }

    public void navigate() {
        open(EnvironmentProperties.getBaseUrl() + getRelativeUrl());
        waitUntilPageIsLoaded();
    }

    protected abstract String getRelativeUrl();

    protected void waitUntilPageIsLoaded() {
        //TODO: generic wait for all pages, for example wait until javascript, jquery, angular, etc. is ready when used
    }
}
