package util.drivermanagers;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ThreadGuard;

import java.io.File;

public class InternetExplorerDriverManager extends DriverManager {

    private ThreadLocal<InternetExplorerDriverService> driverService = new ThreadLocal<>();

    @Override
    public void startService() {
        try {
            driverService.set(new InternetExplorerDriverService.Builder()
                    .usingDriverExecutable(new File(".\\src\\main\\resources\\drivers\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe"))
                    .usingAnyFreePort()
                    .build());
            driverService.get().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopService() {
        driverService.get().stop();
    }

    @Override
    public void createDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.introduceFlakinessByIgnoringSecurityDomains();
        options.destructivelyEnsureCleanSession();
        options.requireWindowFocus();
        options.ignoreZoomSettings();

        driver.set(ThreadGuard.protect(new InternetExplorerDriver(driverService.get(), options)));
    }

}
