package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.openqa.selenium.*;

import util.*;
import util.drivermanagers.DriverManager;
import util.drivermanagers.DriverManagerFactory;

import util.properties.SystemProperties;

public class ScenarioManager {

    private DriverManager driverManager = null;
    private DriverType driverType = null;

    @Before
    public void beforeScenario() {
        driverType = SystemProperties.getDriverType();
        driverManager = DriverManagerFactory.getManager(driverType);
        driverManager.startDriver();

        maximizeWindow();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getWebdriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
        }
        driverManager.quitDriver();
    }

    private void maximizeWindow() {
        DriverManager.getWebdriver().manage().window().maximize();
    }
}
