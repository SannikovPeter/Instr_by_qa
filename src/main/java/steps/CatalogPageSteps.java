package steps;

import org.openqa.selenium.WebDriver;
import pageObjects.CatalogPage;

public class CatalogPageSteps extends BasePageSteps {
    private CatalogPage catalogPage;
    private WebDriver driver;

    public CatalogPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        catalogPage = new CatalogPage(driver);
    }

    @Override
    public boolean isPageCorrect() {
        return catalogPage.getURL().equals(driver.getCurrentUrl());
    }
}
