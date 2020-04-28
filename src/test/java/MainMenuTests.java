import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.CatalogPageSteps;
import steps.ConstructionAndRepairBlogSteps;
import steps.MainPageSteps;

public class MainMenuTests extends WebDriverSettings {

    private MainPageSteps mainPageSteps;

    @BeforeTest
    public void start() {
        mainPageSteps = new MainPageSteps(driver);
    }

    @AfterMethod
    public void endTest() {
        backToStartPage();
    }

    @Test
    public void dropDownMenuTest() {
        ConstructionAndRepairBlogSteps constructionAndRepairBlogSteps;
        constructionAndRepairBlogSteps = mainPageSteps.getMainMenuSteps().openBlogConstructionAndRepairPage();
        Assert.assertTrue(constructionAndRepairBlogSteps.isPageCorrect());
    }

    @Test
    public void catalogButtonTest() {
        CatalogPageSteps catalogPageSteps;
        catalogPageSteps = mainPageSteps.getMainMenuSteps().openCatalogPage();
        Assert.assertTrue(catalogPageSteps.isPageCorrect());
    }

}
