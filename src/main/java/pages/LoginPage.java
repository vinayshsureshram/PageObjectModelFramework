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
        userName.sendKeys(user);
        return this;
    }

    public LoginPage enterPassword(String pass){
        password.sendKeys(pass);
        return this;
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
