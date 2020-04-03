package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.UserProfilePage;

public class UserProfileSteps extends BasePageSteps {

    private UserProfilePage userProfilePage;
    private WebDriver driver;

    public UserProfileSteps(WebDriver driver) {
        this.driver = driver;
        userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
    }

    public boolean isUserProfilePage() {
        return userProfilePage.getProfileCore().isDisplayed();
    }
}
