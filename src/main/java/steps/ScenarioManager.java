package steps;

import com.codeborne.selenide.Configuration;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import util.*;

import util.properties.EnvironmentProperties;
import util.properties.SystemProperties;

public class ScenarioManager {

    private DriverType driverType = null;

    @Before
    public void beforeScenario() {
        driverType = SystemProperties.getDriverType();

        Configuration.browser = driverType.toString();
        Configuration.timeout = EnvironmentProperties.getTimeoutInMilliSeconds();
        Configuration.baseUrl = EnvironmentProperties.getBaseUrl();
        Configuration.pollingInterval = EnvironmentProperties.getSleepInMillis();
        Configuration.startMaximized = true;
        Configuration.browserCapabilities.setJavascriptEnabled(true);
//        Configuration.browserCapabilities.setAcceptInsecureCerts(true);
        Configuration.browserCapabilities.setCapability("ignoreZoomSetting", true);
        Configuration.browserCapabilities.setCapability("ignoreProtectedModeSettings", true);
    }

    @After
    public void afterScenario(Scenario scenario) {
//        if (scenario.isFailed()) {
//            // Take a screenshot...
//            final byte[] screenshot = ((TakesScreenshot) DriverManager.getWebdriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
//        }
    }

}
