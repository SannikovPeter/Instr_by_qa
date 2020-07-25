import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.LoginPageSteps;

public class InsertTests extends AllTestsSettings {

    private LoginPageSteps loginPageSteps;

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
        Assert.assertTrue(loginPageSteps.successLogin(loginName, loginPassword).isPageCorrect());
    }

    @Test
    public void unsuccessfulInsertTest() {
        String wrongName = "Name";
        String wrongPassword = "1234";

        Assert.assertTrue(loginPageSteps.unsuccessfulLogin(wrongName, wrongPassword).isAlertPresent());
    }

    @AfterMethod
    public void endTest() {
        mainPageSteps.backToMainPage();
    }

}
