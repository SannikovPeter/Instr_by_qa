package com.sannikov.objects.popUp;

import com.sannikov.objects.AbstractBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.annotations.Block;

@Component
@Block(@FindBy(css = "#fancybox-wrap"))
public class SearchPageConfirmForm extends AbstractBase {

    @FindBy(css = ".continue_link")
    private WebElement continueButton;
    @FindBy(css = ".showcart")
    private WebElement showCartButton;

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getShowCartButton() {
        return showCartButton;
    }
}
