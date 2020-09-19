package com.sannikov.objects.elements;

import com.sannikov.objects.AbstractBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.annotations.Block;

@Component
@Block(@FindBy(css = "tr"))
public class TableRow extends AbstractBase {

    @FindBy(css = ".vm2-remove_from_cart")
    private WebElement removeButton;
    @FindBy(css = ".PricesalesPrice span")
    private WebElement itemTotal;

    public WebElement getRemoveButton() {
        return removeButton;
    }

    public WebElement getItemTotal() {
        return itemTotal;
    }

}
