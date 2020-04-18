import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.CartPageSteps;
import steps.CatalogPageSteps;
import steps.SearchPageSteps;
import steps.MainPageSteps;

public class CartTests extends WebDriverSettings {

    private MainPageSteps mainPageSteps;
    private SearchPageSteps searchPageSteps;
    private CartPageSteps cartPageSteps;
    private CatalogPageSteps catalogPageSteps;
    private String itemName = "Пила циркулярная";
    private int[] indexesOfItem = {0, 2, 1, 5, 6};

    @BeforeTest
    public void start() {
        mainPageSteps = new MainPageSteps(driver);
        mainPageSteps.openLoginPage().successLogin(name, password);
        mainPageSteps.removeAllItemsFromCart();
    }

    @Test
    public void isItemsAddToCartTest() {
        addItemsToCart(itemName, indexesOfItem);
        cartPageSteps = mainPageSteps.openCartPage();

        Assert.assertEquals(cartPageSteps.getNumberOfItems(), indexesOfItem.length, "Number of items are not equal");
    }

    @Test
    public void cartMemoryTest() {
        addItemsToCart(itemName, indexesOfItem);
        mainPageSteps.exit();
        mainPageSteps.openLoginPage().successLogin(name, password);
        int numberOfItems = mainPageSteps.openCartPage().getNumberOfItems();

        Assert.assertEquals(indexesOfItem.length, numberOfItems, "Number are not equal");
    }

    @Test
    public void isCartMoveToWithAuthorisationTest() {
        mainPageSteps.exit();
        addItemsToCart(itemName, indexesOfItem);
        int unLoginNumberOfItems = mainPageSteps.openCartPage().getNumberOfItems();
        mainPageSteps.openLoginPage().successLogin(name, password);
        int loginNumberOfItems = mainPageSteps.openCartPage().getNumberOfItems();

        Assert.assertEquals(unLoginNumberOfItems, loginNumberOfItems);
    }

    @Test
    public void isItemsPriceIsSummaryTest() {

        addItemsToCart(itemName, indexesOfItem);

        cartPageSteps = mainPageSteps.openCartPage();

        Assert.assertEquals(cartPageSteps.getTotalBill(), cartPageSteps.getSumOfItemPrices(), "Sum and total bill are not equal");
    }

    private void addItemsToCart(String itemName, int[] indexOfItems) {
        for (int itemIndex : indexesOfItem) {
            searchPageSteps = mainPageSteps.search(itemName);
            searchPageSteps.getItem(itemIndex).addItemToCart();
            catalogPageSteps = searchPageSteps.continueShopping();
            catalogPageSteps.backToMainPage();
        }
    }
}
