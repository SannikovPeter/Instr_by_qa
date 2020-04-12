package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.ItemPage;

public class ItemPageSteps extends BasePageSteps {

    private WebDriver driver;
    private ItemPage itemPage;

    public ItemPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        itemPage = PageFactory.initElements(driver, ItemPage.class);
    }

    public void addToCart() {
        itemPage.getAddToCartButton().click();
        waitUntilBeClickableAndClick(itemPage.getContinueButton());
    }

}
