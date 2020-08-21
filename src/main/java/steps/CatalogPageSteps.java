package steps;

import core.AppContext;
import core.BrowserManager;
import org.openqa.selenium.WebDriver;
import pageObjects.CatalogPage;

public class CatalogPageSteps extends BasePageSteps {
    private final CatalogPage catalogPage;
    private final WebDriver driver;

    public CatalogPageSteps() {
        driver = AppContext.getBean(BrowserManager.class).getDriver();
        catalogPage = new CatalogPage();
    }

    @Override
    public boolean isPageCorrect() {
        return catalogPage.getURL().equals(driver.getCurrentUrl());
    }
}
