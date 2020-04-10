package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.MainPage;

public class MainPageSteps extends BasePageSteps {
    private MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        super(driver);
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }


}
