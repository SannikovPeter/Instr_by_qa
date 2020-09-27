package com.sannikov;

import com.sannikov.steps.CatalogPageSteps;
import com.sannikov.steps.ConstructionAndRepairBlogSteps;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MainMenuTest extends TestConfig {

    @AfterMethod(alwaysRun= true)
    public void endTest() {
        mainPageSteps.getHeader().backToMainPage();
    }

    @Test
    public void dropDownMenuTest() {

        ConstructionAndRepairBlogSteps constructionAndRepairBlogSteps;
        constructionAndRepairBlogSteps = mainPageSteps
                .getHeader()
                .getMainMenuSteps()
                .openBlogConstructionAndRepairPage();
        Assert.assertTrue(constructionAndRepairBlogSteps.isPageCorrect());
    }

    @Test
    public void catalogButtonTest() {
        CatalogPageSteps catalogPageSteps;
        catalogPageSteps = mainPageSteps
                .getHeader()
                .getMainMenuSteps()
                .openCatalogPage();
        Assert.assertTrue(catalogPageSteps.isPageCorrect());
    }

    @AfterClass(alwaysRun= true)
    public void endMainMenuTest(){
        browserManager.closeBrowser();
    }
}
