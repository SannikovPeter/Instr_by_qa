import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.CartPageSteps;
import steps.MainPageSteps;

public class SimpleTests extends WebDriverSettings {

    private MainPageSteps mainPageSteps;
    private CartPageSteps cartPageSteps;
    private String name = "Peter";
    private String password = "1234qwerty";

    @BeforeTest
    public void start() {
        mainPageSteps = new MainPageSteps(driver);
    }

    @Test
    public void successLoginTest() {
        boolean isLoginSuccess = mainPageSteps.getLoginPageSteps().successLogin(name, password).isUserProfilePage();
        Assert.assertTrue(isLoginSuccess, "Login is fail");
    }

    @Test
    public void isItemsAddToCartTest() {
        String itemName = "Пила циркулярная";
        int[] indexOfItem = {0, 2};

        removeAllItemsFromCart();
        addItemsToCart(itemName, indexOfItem);
        cartPageSteps = mainPageSteps.openCartPage();

        Assert.assertEquals(cartPageSteps.getNumberOfItems(), indexOfItem.length, "Number of items are not equal");
    }

    @Test
    public void isItemsPriceIsSummaryTest() {
        String itemName = "Пила циркулярная";
        int[] indexOfItem = {0, 2, 1, 5, 6};

        mainPageSteps.getLoginPageSteps().successLogin(name, password);
        removeAllItemsFromCart();
        addItemsToCart(itemName, indexOfItem);
        cartPageSteps = mainPageSteps.openCartPage();

        Assert.assertEquals(cartPageSteps.getTotalBill(), cartPageSteps.getSumOfItemPrices(), "Sum and total bill are not equal");
    }

    private void removeAllItemsFromCart() {
        if (!mainPageSteps.isCartEmpty()) {
            cartPageSteps = mainPageSteps.openCartPage();
            int numberOfItems = cartPageSteps.getNumberOfItems();
            for (int y = 0; y < numberOfItems; y++) {
                cartPageSteps.removeItem(0);
            }
        }
    }

    private void addItemsToCart(String nameOfItem, int[] indexOfItems) {
        for (int indexOfItem : indexOfItems) {
            mainPageSteps.search(nameOfItem).getItem(indexOfItem).addItemToCart().continueShopping();
        }
    }

}
