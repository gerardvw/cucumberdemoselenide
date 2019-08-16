package util.drivermanagers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ThreadGuard;

import java.io.File;

public class ChromeDriverManager extends DriverManager {

    private ThreadLocal<ChromeDriverService> driverService = new ThreadLocal<>();

    @Override
    public void startService() {
        try {
            driverService.set(new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(".\\src\\main\\resources\\drivers\\chromedriver_win32\\chromedriver.exe"))
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
        driver.set(ThreadGuard.protect(new ChromeDriver(driverService.get())));
    }

}
