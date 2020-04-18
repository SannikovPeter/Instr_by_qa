import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.SearchPageSteps;
import steps.MainPageSteps;

public class SearchTests extends WebDriverSettings {

    private MainPageSteps mainPageSteps;
    private SearchPageSteps searchPageSteps;

    @BeforeTest
    public void start() {
        mainPageSteps = new MainPageSteps(driver);
        mainPageSteps.openLoginPage().successLogin(name, password).backToMainPage();
    }

    @Test
    public void searchItemFirstTest() {
        String searchItem = "Pro KT5020";
        String actualItemName;
        byte firstItem = 0;

        searchPageSteps = mainPageSteps.search(searchItem);
        actualItemName = searchPageSteps.getItem(firstItem).getItemName();
        Assert.assertTrue(actualItemName.contains(searchItem.toUpperCase()), "Search item is not first");
    }
}
