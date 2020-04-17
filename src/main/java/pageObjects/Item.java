package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Item extends Base {

    private By AddToCartButton = By.name("addtocart");

    private WebElement itemLocator;

//    public Item(WebDriver driver, WebElement itemLocator) {
//        super(driver);
//        this.itemLocator = itemLocator;
//    }

    public Item(WebElement itemLocator) {
        this.itemLocator = itemLocator;
    }

    public WebElement getAddToCartButton() {
        return itemLocator.findElement(AddToCartButton);
    }

    public WebElement getItemLocator() {
        return itemLocator;
    }
}
