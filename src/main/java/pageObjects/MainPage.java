package pageObjects;

import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private final static String correctURL = "https://instr.by/";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return correctURL;
    }
}
