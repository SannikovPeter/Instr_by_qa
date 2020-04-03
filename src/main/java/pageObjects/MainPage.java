package pageObjects;

import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
