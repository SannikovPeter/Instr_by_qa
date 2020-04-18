package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private String uRL = "https://instr.by/sign-in";

    @FindBy(css = ".alert-warning")
    private WebElement alertWrongNameOrPassword;
    @FindBy(id = "username")
    private WebElement userNameBar;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "remember")
    private WebElement rememberMeBox;
    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getURL() {
        return uRL;
    }

    public WebElement getUserNameBar() {
        return userNameBar;
    }

    public WebElement getPasswordBar() {
        return password;
    }

    public WebElement getRememberMeBox() {
        return rememberMeBox;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getAlertWrongNameOrPassword() {
        return alertWrongNameOrPassword;
    }

}
