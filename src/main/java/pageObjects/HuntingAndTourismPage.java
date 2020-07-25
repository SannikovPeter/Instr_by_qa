package pageObjects;

import org.openqa.selenium.WebDriver;

public class HuntingAndTourismPage extends BasePage {

    private final static String correctURL = "https://instr.by/blog/travel-hunting";

    public HuntingAndTourismPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return correctURL;
    }
}
