package pageObjects;

import org.openqa.selenium.WebDriver;

public class ServicePage extends BasePage {
    private final static String correctURL = "https://instr.by/servis";

    public ServicePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return correctURL;
    }
}
