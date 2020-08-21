package steps;

import core.AppContext;
import core.BrowserManager;
import org.openqa.selenium.WebDriver;
import pageObjects.UserProfilePage;

public class UserProfilePageSteps extends BasePageSteps {

    private final UserProfilePage userProfilePage;
    private final WebDriver driver;

    public UserProfilePageSteps() {
        driver = AppContext.getBean(BrowserManager.class).getDriver();
        userProfilePage = new UserProfilePage();
    }

    @Override
    public boolean isPageCorrect() {
        return userProfilePage.getURL().equals(driver.getCurrentUrl());
    }
}
