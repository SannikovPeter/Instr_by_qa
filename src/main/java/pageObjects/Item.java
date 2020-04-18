package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Item extends Base {

    private By itemDescriptionLocator = By.cssSelector(".vm-product-descr-container-1");
    private By AddToCartButton = By.name("addtocart");

    private WebElement itemLocator;
    private WebElement itemDescription;

    public Item(WebElement itemLocator) {
        this.itemLocator = itemLocator;
        itemDescription = itemLocator.findElement(itemDescriptionLocator);
    }

    public WebElement getAddToCartButton() {
        return itemLocator.findElement(AddToCartButton);
    }

    public WebElement getItemLocator() {
        return itemLocator;
    }

    public WebElement getName() {
        return itemDescription.findElement(By.tagName("h2"));
    }
}
