package pageObjects;

import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private String correctURL = "https://instr.by/";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return correctURL;
    }
}
