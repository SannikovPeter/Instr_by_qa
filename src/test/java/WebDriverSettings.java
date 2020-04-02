import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {

    private static final int TIME = 10;
    WebDriver driver;

    @BeforeTest
    public void WebSettings() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://onliner.by/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(TIME, TimeUnit.SECONDS);
    }

    @Test
    public void test(){
        hardWait();
        driver.findElement(By.id("weather-informer")).click();
        hardWait();
    }

    public void hardWait(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    void closeBrowser() {
        driver.quit();
    }
}
