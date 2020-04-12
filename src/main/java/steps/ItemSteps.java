package steps;

import org.openqa.selenium.WebDriver;
import pageObjects.Item;

public class ItemSteps extends BaseSteps {

    private Item item;
    private WebDriver driver;

    public ItemSteps(WebDriver driver, int indexOfItem) {
        super(driver);
        this.driver = driver;
        item = new Item(driver, indexOfItem);
    }

    public CatalogPageSteps addItemToCart() {
        try {
            item.getAddToCartButton().click();
        } catch (Exception e) {
            scrollWindow(100);
            item.getAddToCartButton().click();
        }

        return new CatalogPageSteps(driver);
    }

    public ItemPageSteps getItemPage() {
        item.getItemLocator().click();
        return new ItemPageSteps(driver);
    }

}
