package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//span[text()='Products']")
    private WebElement productsHeader;

    public boolean verifyProductHeaderIsDisplayed() {
        return productsHeader.isDisplayed();
    }
}
