package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement userNameBar;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "remember")
    private WebElement rememberMeBox;
    @FindBy(xpath = "//*[@id=\"t3-content\"]/div[2]/div/form/fieldset/div[4]/div/button")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
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

}
