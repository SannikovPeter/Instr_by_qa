package steps;

import org.openqa.selenium.WebDriver;
import pageObjects.Item;

public class ItemSteps extends BaseSteps {

    private Item item;
    private WebDriver driver;

    public ItemSteps(WebDriver driver, Item item) {
        super(driver);
        this.driver = driver;
        this.item = item;
//        item = PageFactory.initElements(driver, Item.class);
    }

    public void addItemToCart() {
        try {
            item.getAddToCartButton().click();
        } catch (Exception e) {
            scrollWindow(100);
            waitUntilBeClickableAndClick(item.getAddToCartButton());
//            item.getAddToCartButton().click();
        }
    }

    public ItemPageSteps getItemPage() {
        item.getItemLocator().click();
        return new ItemPageSteps(driver);
    }

    public String getItemName(){
        return item.getName().getText();
    }

}
