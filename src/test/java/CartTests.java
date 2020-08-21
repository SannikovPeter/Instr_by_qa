import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.CartPageSteps;
import steps.CatalogPageSteps;
import steps.SearchPageSteps;

public class CartTests extends TestsConfig {

    private static final Logger logger = LoggerFactory.getLogger(CartTests.class);

    private SearchPageSteps searchPageSteps;
    private CartPageSteps cartPageSteps;
    private CatalogPageSteps catalogPageSteps;
    private final String searchingItemName = "Пила циркулярная";
    private final int[] indexOfItems = {0, 5, 6};

    @BeforeTest
    public void start() {
        mainPageSteps.openLoginPage().successLogin(loginName, loginPassword);
        mainPageSteps.removeAllItemsFromCart();
    }

    @Test
    public void isItemsAddToCartTest() {
        addMassiveOfItemsToCart(searchingItemName, indexOfItems);
        cartPageSteps = mainPageSteps.openCartPage();

        Assert.assertEquals(cartPageSteps.getAmountOfItems(), indexOfItems.length, "Number of items are not equal");
    }

    @Test
    public void cartMemoryTest() {
        addMassiveOfItemsToCart(searchingItemName, indexOfItems);
        mainPageSteps.exit();
        mainPageSteps.openLoginPage().successLogin(loginName, loginPassword);
        int numberOfItems = mainPageSteps.openCartPage().getAmountOfItems();

        Assert.assertEquals(indexOfItems.length, numberOfItems, "Number are not equal");
    }

    @Test
    public void isCartMoveToWithAuthorisationTest() {
        mainPageSteps.exit();
        addMassiveOfItemsToCart(searchingItemName, indexOfItems);
        int unLoginNumberOfItems = mainPageSteps.openCartPage().getAmountOfItems();
        mainPageSteps.openLoginPage().successLogin(loginName, loginPassword);
        int loginNumberOfItems = mainPageSteps.openCartPage().getAmountOfItems();

        Assert.assertEquals(unLoginNumberOfItems, loginNumberOfItems);
    }

    @Test
    public void isItemsPriceIsSummaryTest() {
        addMassiveOfItemsToCart(searchingItemName, indexOfItems);
        cartPageSteps = mainPageSteps.openCartPage();

        Assert.assertEquals(cartPageSteps.getTotalBill(), cartPageSteps.getSumOfItemPrices(), "Sum and total bill are not equal");
    }

    private void addMassiveOfItemsToCart(String itemName, int[] indexOfItems) {
        for (int itemIndex : indexOfItems) {
            searchPageSteps = mainPageSteps.search(itemName);
            searchPageSteps.getItem(itemIndex).addItemToCart();
            catalogPageSteps = searchPageSteps.continueShopping();
            catalogPageSteps.backToMainPage();
        }
    }
}
