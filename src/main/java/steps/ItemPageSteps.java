package steps;

import org.openqa.selenium.WebDriver;
import pageObjects.ItemPage;

public class ItemPageSteps extends BasePageSteps {

    private WebDriver driver;
    private ItemPage itemPage;

    public ItemPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        itemPage = new ItemPage(driver);
    }

    public SearchPageSteps addToCart() {
        itemPage.getAddToCartButton().click();
        waitUntilBeClickableAndClick(itemPage.getContinueButton());
        return new SearchPageSteps(driver);
    }

}
