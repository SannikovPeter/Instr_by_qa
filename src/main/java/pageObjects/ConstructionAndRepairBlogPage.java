package pageObjects;

import org.openqa.selenium.WebDriver;

public class ConstructionAndRepairBlogPage extends BasePage {

    private String uRL = "https://instr.by/blog/strojka-i-remont";

    public ConstructionAndRepairBlogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return uRL;
    }
}
