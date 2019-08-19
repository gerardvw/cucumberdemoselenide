//package util.drivermanagers;
//
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ThreadGuard;
//
//import java.io.File;
//
//public class PhantomJsDriverManager extends DriverManager {
//
//    private ThreadLocal<PhantomJSDriverService> driverService = new ThreadLocal<>();
//
//    @Override
//    public void startService() {
//        try {
//            driverService.set(new PhantomJSDriverService.Builder()
//                    .usingPhantomJSExecutable(new File(".\\src\\main\\resources\\drivers\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe"))
//                    .usingAnyFreePort()
//                    .build());
//            driverService.get().start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void stopService() {
//        driverService.get().stop();
//    }
//
//    @Override
//    public void createDriver() {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setJavascriptEnabled(true);
//        caps.setCapability("takesScreenshot", false);
//
//        driver.set(ThreadGuard.protect(new PhantomJSDriver(driverService.get(), caps)));
//    }
//
//}
