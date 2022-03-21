package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Insert Common Page Operations such as find, finds, tap, scroll etc.

    public WebElement find(WebElement ele, int... args) {
        int timeout = (args.length > 0 ? args[0] : 15);
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofMillis(200))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);

            WebElement webelement = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return ele;
                }
            });
            return webelement;
        } catch (Exception e) {
            return null;
        }
    }
}
