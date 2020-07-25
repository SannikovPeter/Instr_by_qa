import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import steps.CatalogPageSteps;
import steps.ConstructionAndRepairBlogSteps;

public class MainMenuTests extends AllTestsSettings {

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
