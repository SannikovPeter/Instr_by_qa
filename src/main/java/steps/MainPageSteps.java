package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.MainPage;

public class MainPageSteps extends BasePageSteps {
    private MainPage mainPage;
    private WebDriver driver;

    public MainPageSteps(WebDriver driver) {
        this.driver = driver;
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    public LoginPageSteps getLoginPageSteps(){
        mainPage.getLoginButton().click();
        return new LoginPageSteps(driver);
    }
}
