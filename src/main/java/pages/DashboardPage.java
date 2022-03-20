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

    @FindBy (id = "react-burger-menu-btn")
    private WebElement hamburgerMenu;

    @FindBy (id = "logout_sidebar_link")
    private WebElement logOutButton;

    public boolean verifyProductHeaderIsDisplayed() {
        return productsHeader.isDisplayed();
    }

    public DashboardPage clickHamBurgerMenu() {
        hamburgerMenu.click();
        return this;
    }

    public void clickLogOut() {
        logOutButton.click();
    }
}
