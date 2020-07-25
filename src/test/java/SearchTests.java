import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.SearchPageSteps;

public class SearchTests extends AllTestsSettings {

    private SearchPageSteps searchPageSteps;

    @BeforeTest
    public void start() {
        mainPageSteps.openLoginPage().successLogin(loginName, loginPassword).backToMainPage();
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
