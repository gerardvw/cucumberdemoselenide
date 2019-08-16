package util.properties;

import util.Environment;

import java.util.Properties;

public class EnvironmentProperties {

    private Environment environment;
    private Properties properties;

    private static EnvironmentProperties instance;

    private EnvironmentProperties() {
        environment = SystemProperties.getEnvironment();
        properties = new java.util.Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("config/" + environment.name() + ".properties"));
        } catch (Exception eta) {
            eta.printStackTrace();
        }
    }

    private static String getProperty(String key) {
        if (instance == null) {
            instance = new EnvironmentProperties();
        }
        return instance.properties.getProperty(key);
    }

    public static Long getTimeoutInSeconds() {
        return Long.parseLong(getProperty("timeoutinseconds"));
    }

    public static Long getSleepInMillis() {
        return Long.parseLong(getProperty("sleepinmillis"));
    }

    public static String getBaseUrl() { return getProperty("baseurl"); }
}