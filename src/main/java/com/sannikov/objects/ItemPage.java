package com.sannikov.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class ItemPage extends HeaderPage {

    @FindBy(name = "addtocart")
    private WebElement addToCartButton;

    @Override
    public String getURL() {
        return null;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }
}
