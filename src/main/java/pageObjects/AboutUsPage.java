package pageObjects;

import org.openqa.selenium.WebDriver;

public class AboutUsPage extends BasePage {
    private final static String correctURL = "https://instr.by/aboutus";

    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return correctURL;
    }
}
