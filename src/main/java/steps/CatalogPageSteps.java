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

    public ItemSteps getItem(int indexOfItem) {
        moveTo(catalogPage.getItemsList().get(indexOfItem).getItemLocator());
        return new ItemSteps(driver, catalogPage.getItemsList().get(indexOfItem));
    }

    public CatalogPageSteps continueShopping() {
        waitUntilBeClickableAndClick(catalogPage.getContinueButton());
        return new CatalogPageSteps(driver);
    }

    public CartPageSteps getCartPage() {
        waitUntilBeClickableAndClick(catalogPage.getPopUpShowCartButton());
        return new CartPageSteps(driver);
    }
}
