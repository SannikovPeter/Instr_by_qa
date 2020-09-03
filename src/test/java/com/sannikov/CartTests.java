package com.sannikov;

import com.sannikov.steps.CartPageSteps;
import com.sannikov.steps.SearchPageSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartTests extends TestsConfig {

    private CartPageSteps cartPageSteps;
    public static final String SEARCHING_ITEM = "Пила циркулярная";
    private final int[] indexOfItems = {0, 5, 6};

    @BeforeClass
    public void start() {
        mainPageSteps.goToLoginPage().successLogin(loginName, loginPassword);
        mainPageSteps.removeAllItemsFromCart();
    }

    @Test
    public void isItemsAddToCartTest() {
        addMassiveOfItemsToCart(SEARCHING_ITEM, indexOfItems);
        cartPageSteps = mainPageSteps.openCartPage();

        Assert.assertEquals(cartPageSteps.getAmountOfItems(), indexOfItems.length, "Number of items are not equal");
    }

    @Test
    public void cartMemoryTest() {
        addMassiveOfItemsToCart(SEARCHING_ITEM, indexOfItems);
        mainPageSteps.exit();
        mainPageSteps.goToLoginPage().successLogin(loginName, loginPassword);
        int numberOfItems = mainPageSteps.openCartPage().getAmountOfItems();

        Assert.assertEquals(indexOfItems.length, numberOfItems, "Number are not equal");
    }

    @Test
    public void isCartMoveToWithAuthorisationTest() {
        mainPageSteps.exit();
        addMassiveOfItemsToCart(SEARCHING_ITEM, indexOfItems);
        int unLoginNumberOfItems = mainPageSteps.openCartPage().getAmountOfItems();
        mainPageSteps.goToLoginPage().successLogin(loginName, loginPassword);
        int loginNumberOfItems = mainPageSteps.openCartPage().getAmountOfItems();

        Assert.assertEquals(unLoginNumberOfItems, loginNumberOfItems);
    }

    @Test
    public void isItemsPriceIsSummaryTest() {
        addMassiveOfItemsToCart(SEARCHING_ITEM, indexOfItems);
        cartPageSteps = mainPageSteps.openCartPage();

        Assert.assertEquals(cartPageSteps.getTotalBill(), cartPageSteps.getSumOfItemPrices(), "Sum and total bill are not equal");
    }

    private void addMassiveOfItemsToCart(String itemName, int[] indexOfItems) {
        for (int itemIndex : indexOfItems) {
            SearchPageSteps searchPageSteps = mainPageSteps.search(itemName);
            searchPageSteps.addItemToCartAndContinueShopping(itemIndex)
                    .backToMainPage();
        }
    }
}
