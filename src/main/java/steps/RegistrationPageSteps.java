package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.RegistrationPage;

public class RegistrationPageSteps extends BasePageSteps {

    private RegistrationPage registrationPage;
    private WebDriver driver;

    public RegistrationPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
    }

    public UserProfilePageSteps registration(String name, String password, String email) {
        registrationPage.getEmailField().sendKeys(email);
        registrationPage.getNameField().sendKeys(name);
        registrationPage.getUserNameField().sendKeys(name);
        registrationPage.getPasswordField().sendKeys(password);
        registrationPage.getConfirmPasswordField().sendKeys(password);
        registrationPage.getCaptchaBox().submit();
        registrationPage.getRegistrationButtonLocator().submit();
        return new UserProfilePageSteps(driver);
    }


}
