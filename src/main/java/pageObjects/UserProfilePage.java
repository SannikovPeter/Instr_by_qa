package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage {

    @FindBy(id = "users-profile-core")
    private WebElement profileCore;

    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProfileCore() {
        return profileCore;
    }

}
