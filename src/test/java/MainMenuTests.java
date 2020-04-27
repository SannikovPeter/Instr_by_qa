import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
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
        mainPageSteps.backToMainPage();
    }
    @Test
    public void dropDownMenuTest(){
        ConstructionAndRepairBlogSteps constructionAndRepairBlogSteps;

        constructionAndRepairBlogSteps = mainPageSteps.getMainMenuSteps().openBlogConstructionAndRepairPage();

        Assert.assertTrue(constructionAndRepairBlogSteps.isPageCorrect());
    }

    @Test
    public void catalogButtonTest() {
        mainPageSteps.getMainMenuSteps().openCatalogPage();

    }
}
