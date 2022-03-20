import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;

public class DriverFactory {
    public static WebDriver getDriver(String browserName) throws MalformedURLException {
        if (browserName == "Chrome") {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserName == "Firefox") {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else
            return null;
    }
}
