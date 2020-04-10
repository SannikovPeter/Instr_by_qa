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

    public void addItemToCart() {
        item.getAddToCartButton().click();
    }

}
