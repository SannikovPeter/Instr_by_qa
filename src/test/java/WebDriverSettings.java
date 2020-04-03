import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebDriverSettings {

    private static final int TIME = 10;
    WebDriver driver;

    @BeforeTest
    public void WebSettings() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://instr.by/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(TIME, TimeUnit.SECONDS);
    }

    @AfterTest
    void closeBrowser() {
        driver.quit();
    }
}
