package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage {

    private final static String url = "https://instr.by/create-an-account/profile";

    @FindBy(id = "users-profile-core")
    private WebElement profileCore;

    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return url;
    }

    public WebElement getProfileCore() {
        return profileCore;
    }

}
