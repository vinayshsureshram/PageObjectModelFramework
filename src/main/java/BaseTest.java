import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.Common;
import pages.DashboardPage;
import pages.LoginPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    private static String browserName;
    private static Properties prop;

    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public Common common;

    @BeforeSuite
    public void setUp() throws IOException {
        //Driver Initialisation
        prop = new Properties();
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java"
                + "/config.properties");
        prop.load(ip);
        browserName = prop.getProperty("browser");

        if(browserName.equals("Chrome")) {
            driver = DriverFactory.getDriver("Chrome");
        } else if(browserName.equals("Firefox")) {
            driver = DriverFactory.getDriver("Firefox");
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Page Objects initialisation
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        common = new Common(driver);
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    public static void getScreenshot(String s) throws IOException {
        File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "\\" + s + ".png"));
    }
}
