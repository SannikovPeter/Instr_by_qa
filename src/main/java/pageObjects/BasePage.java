package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends Base {

    @FindBy(css = ".item-121")
    private WebElement insertButton;
    @FindBy(css = ".create-an-account")
    private WebElement registrationButton;


    public BasePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLoginButton() {
        return insertButton;
    }

    public WebElement getRegistrationButton() {
        return registrationButton;
    }


}
