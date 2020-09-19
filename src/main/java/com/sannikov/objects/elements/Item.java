package com.sannikov.objects.elements;

import com.sannikov.objects.AbstractBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.annotations.Block;

@Component
@Block(@FindBy(css = ".isotope-item"))
public class Item extends AbstractBase {

    @FindBy(css = ".vm-product-descr-container-1")
    private WebElement itemDescription;
    @FindBy(css = ".addtocart-button")
    private WebElement addToCartButton;

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public String getName() {
        return itemDescription.findElement(By.cssSelector("h2")).getText();
    }
}
