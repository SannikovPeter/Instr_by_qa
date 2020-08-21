package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage {

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
