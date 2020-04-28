package steps;

import org.openqa.selenium.WebDriver;
import pageObjects.ConstructionAndRepairBlogPage;

public class ConstructionAndRepairBlogSteps extends BasePageSteps {

    private ConstructionAndRepairBlogPage page;
    private WebDriver driver;

    public ConstructionAndRepairBlogSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        page = new ConstructionAndRepairBlogPage(driver);
    }

    @Override
    public boolean isPageCorrect() {
        return page.getURL().equals(driver.getCurrentUrl());
    }
}
