package pageObjects;

import org.openqa.selenium.WebDriver;

public class BlogPage extends BasePage {
    private final static String correctURL = "https://instr.by/blog";

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return correctURL;
    }
}
