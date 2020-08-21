package steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.CartPage;

public class CartPageSteps extends BasePageSteps {

    private static final Logger logger = LoggerFactory.getLogger(CartPageSteps.class);

    private final CartPage cartPage;

    public CartPageSteps() {
        cartPage = new CartPage();
    }

    public int getAmountOfItems() {
        return cartPage.getRowsList().size() - cartPage.getBaseNumberOfTableRows();
    }

    public double getTotalBill() {
        double result = stringPriceToDouble(cartPage.getTotalBillLocator().getText());
        logger.info("totalBill is: " + result);
        return result;

    }

    public double getItemPrice(int indexOfItem) {
        return stringPriceToDouble(cartPage.getItemTotalLocator(indexOfItem).getText());
    }

    public double getSumOfItemPrices() {
        double sumOfItemPrices = 0;
        for (int i = 0; i < getAmountOfItems(); i++) {
            sumOfItemPrices += getItemPrice(i);
        }
        sumOfItemPrices *= 100;
        int intSum = (int) Math.round(sumOfItemPrices);
        double result = (double) intSum / 100;
        logger.info("sumOfItemPrices is: " + result);
        return result;
    }

    public CartPageSteps removeItem(int indexOfItem) {
        cartPage.removeItemFromCartButton(indexOfItem).click();
        return new CartPageSteps();
    }
}
