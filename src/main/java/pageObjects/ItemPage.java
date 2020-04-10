package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage {

    @FindBy(name = "addtocart")
    private WebElement addToCartButton;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }
}
