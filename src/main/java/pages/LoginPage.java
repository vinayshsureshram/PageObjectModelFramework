package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "user-name")
    private WebElement userName;

    @FindBy (id = "password")
    private WebElement password;

    @FindBy (id = "login-button")
    private WebElement loginButton;

    public LoginPage enterUsername(String user){
        find(userName, 5).sendKeys(user);
        return this;
    }

    public LoginPage enterPassword(String pass){
        find(password, 5).sendKeys(pass);
        return this;
    }

    public void clickLoginButton(){
        find(loginButton).click();
    }
}
