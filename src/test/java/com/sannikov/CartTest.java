package com.sannikov;

import com.sannikov.steps.CartPageSteps;
import com.sannikov.steps.SearchPageSteps;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartTest extends TestConfig {

    public static final String SEARCHING_ITEM = "Пила циркулярная";
    private final int[] indexOfItems = {0, 5, 6};
    private CartPageSteps cartPageSteps;

    @BeforeClass
    public void start() {
        mainPageSteps.getHeader().goToLoginPage().successLogin(loginName, loginPassword);
        mainPageSteps.getHeader().removeAllItemsFromCart();
    }

    @Test
    public void isItemsAddToCartTest() {
        addMassiveOfItemsToCart(SEARCHING_ITEM, indexOfItems);
        cartPageSteps = mainPageSteps.getHeader().openCartPage();

        Assert.assertEquals(cartPageSteps.getAmountOfItems(), indexOfItems.length, "Number of items are not equal");
    }

    @Test
    public void cartMemoryTest() {
        addMassiveOfItemsToCart(SEARCHING_ITEM, indexOfItems);
        mainPageSteps.getHeader().exit();
        mainPageSteps.getHeader().goToLoginPage().successLogin(loginName, loginPassword);
        int numberOfItems = mainPageSteps.getHeader().openCartPage().getAmountOfItems();

        Assert.assertEquals(indexOfItems.length, numberOfItems, "Number are not equal");
    }

    @Test
    public void isCartMoveToWithAuthorisationTest() {
        mainPageSteps.getHeader().exit();
        addMassiveOfItemsToCart(SEARCHING_ITEM, indexOfItems);
        int unLoginNumberOfItems = mainPageSteps.getHeader().openCartPage().getAmountOfItems();
        mainPageSteps.getHeader().goToLoginPage().successLogin(loginName, loginPassword);
        int loginNumberOfItems = mainPageSteps.getHeader().openCartPage().getAmountOfItems();

        Assert.assertEquals(unLoginNumberOfItems, loginNumberOfItems);
    }

    @Test
    public void isItemsPriceIsSummaryTest() {
        addMassiveOfItemsToCart(SEARCHING_ITEM, indexOfItems);
        cartPageSteps = mainPageSteps.getHeader().openCartPage();

        Assert.assertEquals(cartPageSteps.getTotalBill(), cartPageSteps.getSumOfItemPrices(), "Sum and total bill are not equal");
    }

    private void addMassiveOfItemsToCart(String itemName, int[] indexOfItems) {
        for (int itemIndex : indexOfItems) {
            SearchPageSteps searchPageSteps = mainPageSteps.getHeader().search(itemName);
            searchPageSteps.addItemToCartAndContinueShopping(itemIndex)
                    .getHeader()
                    .backToMainPage();
        }
    }

    @AfterClass(alwaysRun= true)
    public void endCartTest(){
        browserManager.closeBrowser();
    }


}
