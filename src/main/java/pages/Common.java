package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Common extends BasePage {

    public LoginPage loginPage = new LoginPage(driver);

    public Common(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement hamburgerMenu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOutButton;


    public Common clickHamBurgerMenu() {
        find(hamburgerMenu).click();
        return this;
    }

    public void clickLogOut() {
        find(logOutButton).click();
    }

    public void logInToApp(String userName, String password) {
        loginPage.enterUsername(userName)
                .enterPassword(password)
                .clickLoginButton();
    }

    public void logOutFromApp() {
        clickHamBurgerMenu()
                .clickLogOut();

    }
}
