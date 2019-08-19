//package util.drivermanagers;
//
//import util.DriverType;
//
//public class DriverManagerFactory {
//
//    public static DriverManager getManager(DriverType type) {
//
//        DriverManager driverManager;
//
//        switch (type) {
//            case chrome:
//                driverManager = new ChromeDriverManager();
//                break;
//            case ie:
//                driverManager = new InternetExplorerDriverManager();
//                break;
//            case phantomjs:
//                driverManager = new PhantomJsDriverManager();
//                break;
//            default:
//                throw new IllegalArgumentException("DriverType " + type.toString() + " not supported (yet)");
//        }
//        return driverManager;
//
//    }
//}
