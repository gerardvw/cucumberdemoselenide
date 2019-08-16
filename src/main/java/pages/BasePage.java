package pages;

import org.openqa.selenium.support.PageFactory;
import util.drivermanagers.DriverManager;
import util.properties.EnvironmentProperties;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverManager.getWebdriver(), this);
    }

    public void navigate() {
        DriverManager.getWebdriver().navigate().to(EnvironmentProperties.getBaseUrl() + getRelativeUrl());
        waitUntilPageIsLoaded();
    }

    protected abstract String getRelativeUrl();

    protected void waitUntilPageIsLoaded() {
        //TODO: generic wait for all pages, for example wait until javascript, jquery, angular, etc. is ready when used
    }
}
