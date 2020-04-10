package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CartPage;

public class CartPageSteps extends BasePageSteps {

    private WebDriver driver;
    private CartPage cartPage;

    public CartPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        cartPage = PageFactory.initElements(driver, CartPage.class);
    }
    //Table has 8 rows
    //items start from second row

    public int getValueOfItems() {
        return cartPage.getTableRows().size();
    }

}
