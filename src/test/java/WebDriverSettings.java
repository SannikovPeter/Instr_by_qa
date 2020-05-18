import config.AppConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import steps.BasePageSteps;

import java.util.concurrent.TimeUnit;

@ContextConfiguration(classes = {AppConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class WebDriverSettings {

    private static final int TIME = 10;
    protected WebDriver driver;
    protected String name = "Peter";
    protected String password = "1234qwerty";
    private BasePageSteps basePageSteps;

    @BeforeTest
    public void WebSettings() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver81.exe");
        driver = new ChromeDriver();
        driver.get("https://instr.by/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(TIME, TimeUnit.SECONDS);
        basePageSteps = new BasePageSteps(driver);
    }

    @AfterTest
    void closeBrowser() {
        driver.quit();
    }

    //NOT USE!!
    public void unacceptableWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void backToStartPage() {
        basePageSteps.backToMainPage();
    }
}
