package steps;

import org.openqa.selenium.WebDriver;
import pageObjects.CartPage;

public class CartPageSteps extends BasePageSteps {

    private WebDriver driver;
    private CartPage cartPage;

    public CartPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        cartPage = new CartPage(driver);
    }

    public int getNumberOfItems() {
        return cartPage.getRowsList().size() - cartPage.getBaseNumberOfTableRows();
    }

    public double getTotalBill() {
        return stringPriceToDouble(cartPage.getTotalBillLocator().getText());
    }

    public double getItemPrice(int indexOfItem) {
        return stringPriceToDouble(cartPage.getItemTotalLocator(indexOfItem).getText());
    }

    public double getSumOfItemPrices() {
        double sumOfItemPrices = 0;
        for (int i = 0; i < getNumberOfItems(); i++) {
            sumOfItemPrices += getItemPrice(i);
        }
        return sumOfItemPrices;
    }

    public CartPageSteps removeItem(int indexOfItem) {
        cartPage.removeItemFromCartButton(indexOfItem).click();
        return new CartPageSteps(driver);
    }
}
