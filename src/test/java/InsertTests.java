import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.LoginPageSteps;
import steps.MainPageSteps;

public class InsertTests extends WebDriverSettings {

    private MainPageSteps mainPageSteps;
    private LoginPageSteps loginPageSteps;

    @BeforeTest
    public void start() {
        mainPageSteps = new MainPageSteps(driver);
    }

    @BeforeMethod
    public void checkLogOut() {
        mainPageSteps.checkLogIn();
        loginPageSteps = mainPageSteps.openLoginPage();
    }

    @Test
    public void checkOpenLoginPage() {
        Assert.assertTrue(loginPageSteps.isPageCorrect());
    }

    @Test
    public void successInsertTest() {
        String name = "Peter";
        String password = "1234qwerty";

        Assert.assertTrue(loginPageSteps.successLogin(name, password).isPageCorrect());
    }

    @Test
    public void unsuccessfulInsertTest() {
        String name = "Name";
        String password = "1234";

        Assert.assertTrue(loginPageSteps.unsuccessfulLogin(name, password).isAlertPresent());
    }

    @AfterMethod
    public void endTest(){
        mainPageSteps.backToMainPage();
    }

}
