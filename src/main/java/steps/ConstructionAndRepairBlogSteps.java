package steps;

import core.AppContext;
import core.BrowserManager;
import org.openqa.selenium.WebDriver;
import pageObjects.ConstructionAndRepairBlogPage;

public class ConstructionAndRepairBlogSteps extends BasePageSteps {
    private final ConstructionAndRepairBlogPage page;
    private final WebDriver driver;

    public ConstructionAndRepairBlogSteps() {
        driver = AppContext.getBean(BrowserManager.class).getDriver();
        page = new ConstructionAndRepairBlogPage();
    }

    @Override
    public boolean isPageCorrect() {
        return page.getURL().equals(driver.getCurrentUrl());
    }
}
