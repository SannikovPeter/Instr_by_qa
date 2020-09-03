package com.sannikov;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.sannikov.steps.CatalogPageSteps;
import com.sannikov.steps.ConstructionAndRepairBlogSteps;

public class MainMenuTests extends TestsConfig {

    @AfterMethod
    public void endTest() {
        mainPageSteps.backToMainPage();
    }

    @Test
    public void dropDownMenuTest() {

        ConstructionAndRepairBlogSteps constructionAndRepairBlogSteps;
        constructionAndRepairBlogSteps = mainPageSteps
                .getMainMenuSteps()
                .openBlogConstructionAndRepairPage();
        Assert.assertTrue(constructionAndRepairBlogSteps.isPageCorrect());
    }

    @Test
    public void catalogButtonTest() {
        CatalogPageSteps catalogPageSteps;
        catalogPageSteps = mainPageSteps
                .getMainMenuSteps()
                .openCatalogPage();
        Assert.assertTrue(catalogPageSteps.isPageCorrect());
    }
}
