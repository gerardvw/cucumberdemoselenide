//package util.drivermanagers;
//
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import util.properties.EnvironmentProperties;
//
//public abstract class DriverManager {
//
//    protected static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//    protected abstract void startService();
//    protected abstract void stopService();
//    protected abstract void createDriver();
//
//    public synchronized void startDriver() {
//        startService();
//        createDriver();
//    }
//
//    public synchronized void quitDriver() {
//        getWebdriver().close();
//        getWebdriver().quit();
//
//        stopService();
//    }
//
//    public synchronized static WebDriver getWebdriver() {
//        return driver.get();
//    }
//
//    public synchronized static WebDriverWait getWebDriverWait() {
//        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getWebdriver(), EnvironmentProperties.getTimeoutInSeconds(), EnvironmentProperties.getSleepInMillis());
//        webDriverWait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
//        return webDriverWait;
//    }
//}
