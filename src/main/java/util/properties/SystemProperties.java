package util.properties;

import util.DriverType;
import util.Environment;

public class SystemProperties {

    private SystemProperties() {
    }

    public static Environment getEnvironment() {
        String environmentSystemProperty = System.getProperty("env");
        return (environmentSystemProperty == null) ? Environment.dev : Environment.valueOf(environmentSystemProperty.toLowerCase());
    }

    public static DriverType getDriverType() {
        String browserSystemProperty = System.getProperty("browser");
        return (browserSystemProperty == null) ? DriverType.chrome : DriverType.valueOf(browserSystemProperty.toLowerCase());
    }
}