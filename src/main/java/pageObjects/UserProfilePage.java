package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage {
    private String URL_MATCH = "https://instr.by/create-an-account/profile";
    @FindBy(id = "users-profile-core")
    private WebElement profileCore;

    private WebDriver driver;

    public UserProfilePage(WebDriver driver) {
        super(driver);
        if (!driver.getCurrentUrl().contains(URL_MATCH)) {
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }
        this.driver = driver;
    }

    public WebElement getProfileCore() {
        return profileCore;
    }

}
