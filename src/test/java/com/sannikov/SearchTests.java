package com.sannikov;

import com.sannikov.steps.SearchPageSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTests extends TestsConfig {

    private SearchPageSteps searchPageSteps;

    @BeforeClass
    public void start() {
        mainPageSteps.goToLoginPage().successLogin(loginName, loginPassword).backToMainPage();
    }

    @Test
    public void searchItemFirstTest() {
        String searchItem = "Pro KT5020";
        String actualItemName;
        int firstItem = 0;

        searchPageSteps = mainPageSteps.search(searchItem);
        actualItemName = searchPageSteps.getItem(firstItem).getItemName();
        Assert.assertTrue(actualItemName.contains(searchItem.toUpperCase()), "Search item is not first");
    }
}
