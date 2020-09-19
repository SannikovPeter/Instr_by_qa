package com.sannikov.objects.pages;

import com.sannikov.objects.AbstractBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.annotations.Block;

@Component
@Block(@FindBy(css = "body"))
public class ItemPage extends AbstractBase {

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
