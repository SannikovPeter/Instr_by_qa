package pageObjects;

import org.openqa.selenium.WebDriver;

public class RentPage extends BasePage {
    private final static String correctURL = "https://instr.by/arenda";

    public RentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return correctURL;
    }
}
