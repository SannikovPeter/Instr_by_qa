package com.sannikov.steps;

import com.sannikov.core.AppContext;
import com.sannikov.objects.AbstractBase;
import com.sannikov.objects.pages.CartPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CartPageSteps extends BaseSteps {

    private static final Logger logger = LoggerFactory.getLogger(CartPageSteps.class);

    private static final ThreadLocal<CartPage> CART_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private CartPage getCartPage() {
        return CART_PAGE_THREAD_LOCAL.get();
    }

    public void setCartPage(CartPage cartPage) {
        CART_PAGE_THREAD_LOCAL.set(cartPage);
    }

    public int getAmountOfItems() {
        return getCartPage().getRowsList().size() - getCartPage().getBaseNumberOfTableRows();
    }

    public double getTotalBill() {
        double result = stringPriceToDouble(getCartPage().getTotalBillLocator().getText());
        logger.info("totalBill is: " + result);
        return result;
    }

    public double getItemPrice(int indexOfItem) {
        return stringPriceToDouble(getCartPage().getItemTotalPriceLocator(indexOfItem).getText());
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
        CartPageSteps cartPageSteps = AppContext.getBean(CartPageSteps.class);
        cartPageSteps.setCartPage(AbstractBase.getPage(CartPage.class));
        getCartPage().removeItemFromCartButton(indexOfItem).click();
        return cartPageSteps;
    }
}
