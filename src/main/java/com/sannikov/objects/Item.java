package com.sannikov.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Item extends AbstractBase {

    private final static By itemDescriptionLocator = By.cssSelector(".vm-product-descr-container-1");
    private final static By AddToCartButton = By.name("addtocart");

    private WebElement itemLocator;

    private WebElement itemDescription;

    public Item() {
    }

    public Item(WebElement itemLocator) {
        this.itemLocator = itemLocator;
        itemDescription = itemLocator.findElement(itemDescriptionLocator);
    }

    public WebElement getItemLocator() {
        return itemLocator;
    }

    public WebElement getAddToCartButton() {
        return itemLocator.findElement(AddToCartButton);
    }

    public WebElement getName() {
        itemDescription = itemLocator.findElement(itemDescriptionLocator);
        return itemDescription.findElement(By.tagName("h2"));
    }
}
