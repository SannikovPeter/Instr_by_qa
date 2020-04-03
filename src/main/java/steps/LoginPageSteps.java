package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.LoginPage;

public class LoginPageSteps extends BasePageSteps {
    private LoginPage loginPage;
    private WebDriver driver;

    public LoginPageSteps(WebDriver driver) {
        this.driver = driver;
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    private void login(String name, String password) {
        loginPage.getUserNameBar().sendKeys(name);
        loginPage.getPasswordBar().sendKeys(password);
        loginPage.getSubmitButton().submit();
    }

    public UserProfileSteps successLogin(String name, String password) {
        login(name,password);
        return new UserProfileSteps(driver);
    }

    public LoginPageSteps unsuccessfulLogin(String name, String password){
        login(name,password);
        return new LoginPageSteps(driver);
    }

}
