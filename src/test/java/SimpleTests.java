import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.MainPageSteps;

public class SimpleTests extends WebDriverSettings {

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

    @Test
    public void isItemsCostSummaryTest(){
        String itemName = "Пила циркулярная";
        int indexOfItem = 0;
        mainPageSteps.getLoginPageSteps().successLogin(name,password).backToMainPage();
        mainPageSteps.search(itemName).addItemToCartAndContinue(indexOfItem).backToMainPage();
        int i = mainPageSteps.search(itemName).addItemToCartAndGetCart(++indexOfItem).getValueOfItems();

        System.out.println(i);

    }
}
