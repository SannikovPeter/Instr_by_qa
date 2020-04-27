package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.ConstructionAndRepairBlogPage;

public class ConstructionAndRepairBlogSteps extends BasePageSteps {

    private ConstructionAndRepairBlogPage constructionAndRepairBlogPage;
    private WebDriver driver;

    public ConstructionAndRepairBlogSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        constructionAndRepairBlogPage = PageFactory.initElements(driver, ConstructionAndRepairBlogPage.class);
    }

    @Override
    public boolean isPageCorrect() {
        return constructionAndRepairBlogPage.getURL().equals(driver.getCurrentUrl());
    }
}
