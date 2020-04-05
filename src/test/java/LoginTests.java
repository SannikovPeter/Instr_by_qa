import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.MainPageSteps;

public class LoginTests extends WebDriverSettings {
    private MainPageSteps mainPageSteps;
    private String name = "Peter";
    private String password = "1234qwerty";

    @BeforeTest
    public void start() {
        mainPageSteps = new MainPageSteps(driver);
    }

//    @Test
//    public void registrationTest() {
//        mainPageSteps.getRegistrationPageSteps().registration(name,password,mail);
//    }

    @Test
    public void successLoginTest() {


        boolean isLoginSuccess = mainPageSteps.getLoginPageSteps().successLogin(name, password).isUserProfilePage();

        Assert.assertTrue(isLoginSuccess, "Login is fail");
    }
}
