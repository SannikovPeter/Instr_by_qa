package pageObjects;

import org.openqa.selenium.WebDriver;

public class InstrNewsPage extends BasePage {
    private String correctURL = "https://instr.by/blog/novosti-ot-instr-by";

    public InstrNewsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return correctURL;
    }
}
