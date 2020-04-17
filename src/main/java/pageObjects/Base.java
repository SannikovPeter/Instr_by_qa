package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {

    private static final int DEFAULT_TIME_OUT = 10;
    private WebDriver driver;
    private WebDriverWait wait;

    public Base(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT));
        PageFactory.initElements(driver, this);
    }

    public Base() {
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
