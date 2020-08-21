package steps;

import core.AppContext;
import core.BrowserManager;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;

public class LoginPageSteps extends BasePageSteps {
    private final LoginPage loginPage;
    private final WebDriver driver;

    public LoginPageSteps() {
        driver = AppContext.getBean(BrowserManager.class).getDriver();
        loginPage = new LoginPage();
    }

    private void login(String name, String password) {
        loginPage.getUserNameBar().sendKeys(name);
        loginPage.getPasswordBar().sendKeys(password);
        loginPage.getSubmitButton().submit();
    }

    public UserProfilePageSteps successLogin(String name, String password) {
        login(name, password);
        return new UserProfilePageSteps();
    }

    public LoginPageSteps unsuccessfulLogin(String name, String password) {
        login(name, password);
        return new LoginPageSteps();
    }

    @Override
    public boolean isPageCorrect() {
        return loginPage.getURL().equals(driver.getCurrentUrl());
    }

    public boolean isAlertPresent() {
        return loginPage.getAlertWrongNameOrPassword().isDisplayed();
    }

}
