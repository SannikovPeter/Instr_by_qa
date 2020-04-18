package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.UserProfilePage;

public class UserProfilePageSteps extends BasePageSteps {

    private UserProfilePage userProfilePage;
    private WebDriver driver;

    public UserProfilePageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
    }

    @Override
    public boolean isPageCorrect() {
        return userProfilePage.getURL().equals(driver.getCurrentUrl());
    }



}
