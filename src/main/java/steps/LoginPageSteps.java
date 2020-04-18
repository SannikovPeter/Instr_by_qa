package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.LoginPage;

public class LoginPageSteps extends BasePageSteps {
    private LoginPage loginPage;
    private WebDriver driver;

    public LoginPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    private void login(String name, String password) {
        loginPage.getUserNameBar().sendKeys(name);
        loginPage.getPasswordBar().sendKeys(password);
        loginPage.getSubmitButton().submit();
    }

    public UserProfilePageSteps successLogin(String name, String password) {
        login(name, password);
        return new UserProfilePageSteps(driver);
    }

    public LoginPageSteps unsuccessfulLogin(String name, String password) {
        login(name, password);
        return new LoginPageSteps(driver);
    }

    @Override
    public boolean isPageCorrect() {
        return loginPage.getURL().equals(driver.getCurrentUrl());
    }

    public boolean isAlertPresent() {
        return loginPage.getAlertWrongNameOrPassword().isDisplayed();
    }

}
