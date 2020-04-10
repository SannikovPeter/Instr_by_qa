package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CatalogPage;

public class CatalogPageSteps extends BasePageSteps {

    private CatalogPage catalogPage;
    private WebDriver driver;

    public CatalogPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        catalogPage = PageFactory.initElements(driver, CatalogPage.class);
    }

    public ItemPageSteps getItemPage(int indexOfItem) {
        moveToElementAndClick(catalogPage.getItemsList().get(indexOfItem));
        return new ItemPageSteps(driver);
    }

    private void addItemToCart(int indexOfItem) {
        moveTo(catalogPage.getItemsList().get(indexOfItem));
        new ItemSteps(driver, indexOfItem).addItemToCart();
    }

    public CatalogPageSteps addItemToCartAndContinue(int indexOfItem) {
        addItemToCart(indexOfItem);
        waitUntilBeClickableAndClick(catalogPage.getContinueButton());
        return new CatalogPageSteps(driver);
    }

    public CartPageSteps addItemToCartAndGetCart(int indexOfItem) {
        addItemToCart(indexOfItem);
        waitUntilBeClickableAndClick(catalogPage.getPopUpShowCartButton());
        return new CartPageSteps(driver);
    }

}
