package pageObjects;

import org.openqa.selenium.WebDriver;

public class CatalogPage extends BasePage {

    private final static String correctURL = "https://instr.by/catalog";

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return correctURL;
    }


}
