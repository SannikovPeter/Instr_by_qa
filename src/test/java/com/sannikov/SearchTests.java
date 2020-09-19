package com.sannikov;

import com.sannikov.steps.SearchPageSteps;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTests extends TestsConfig {

    private SearchPageSteps searchPageSteps;

    @BeforeClass
    public void start() {
        mainPageSteps.getHeader().goToLoginPage().successLogin(loginName, loginPassword).getHeader().backToMainPage();
    }

    @Test
    public void searchItemFirstTest() {
        String searchItem = "Pro KT5020";
        String actualItemName;
        int firstItem = 0;

        searchPageSteps = mainPageSteps.getHeader().search(searchItem);
        actualItemName = searchPageSteps.getItem(firstItem).getItemName();
        Assert.assertTrue(actualItemName.contains(searchItem.toUpperCase()), "Search item is not first");
        //разобраться
    }

    @AfterClass(alwaysRun= true)
    public void endSearchTest(){
        browserManager.closeBrowser();
    }
}
