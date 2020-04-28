package pageObjects;

import org.openqa.selenium.WebDriver;

public class AboutUsPage extends BasePage {
    private String correctURL = "https://instr.by/aboutus";

    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return correctURL;
    }
}
