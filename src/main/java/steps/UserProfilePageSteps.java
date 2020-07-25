package steps;

import org.openqa.selenium.WebDriver;
import pageObjects.UserProfilePage;

public class UserProfilePageSteps extends BasePageSteps {

    private UserProfilePage userProfilePage;
    private WebDriver driver;

    public UserProfilePageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        userProfilePage = new UserProfilePage(driver);
    }

    @Override
    public boolean isPageCorrect() {
        return userProfilePage.getURL().equals(driver.getCurrentUrl());
    }
}
