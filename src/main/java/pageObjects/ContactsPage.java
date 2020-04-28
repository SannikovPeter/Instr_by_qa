package pageObjects;

import org.openqa.selenium.WebDriver;

public class ContactsPage extends BasePage {

    private String correctURL = "https://instr.by/feedback";

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return correctURL;
    }
}
