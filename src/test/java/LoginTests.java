import org.testng.Assert;
import org.testng.annotations.Test;
import steps.MainPageSteps;

public class LoginTests extends WebDriverSettings {

    @Test
    public void successLogin() {
        String name = "name";
        String password = "1234";

        MainPageSteps mainPageSteps = new MainPageSteps(driver);

        boolean isLoginSuccess = mainPageSteps.getLoginPageSteps().successLogin(name, password).isUserProfilePage();

        Assert.assertEquals(isLoginSuccess, true, "Login is fail");
    }
}
