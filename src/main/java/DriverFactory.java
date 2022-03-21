import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;

public class DriverFactory {

    private static WebDriver driver;
    private static DriverFactory driverfactory;

    private DriverFactory() {
    }

    public static DriverFactory getInstance() {
        if (driverfactory == null) {
            driverfactory = new DriverFactory();
        }
        return driverfactory;
    }

    public WebDriver getDriver(String browserName) throws MalformedURLException {
        if (driver == null) {
            if (browserName == "Chrome") {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                return driver;
            } else if (browserName == "Firefox") {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                return driver;
            } else
                return null;
        }
        return driver;
    }
}
