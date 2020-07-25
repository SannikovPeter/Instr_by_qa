package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.MainPageSteps;

import java.util.concurrent.TimeUnit;

public class BrowserManager {

    private static final int WAITING_TIME = 10;

    protected WebDriver driver = null;
    private final PropertiesManager propertiesManager;
    private MainPageSteps mainPageSteps;

    public BrowserManager() {
        propertiesManager = new PropertiesManager();
    }

    public void createBrowser() {
        System.setProperty(propertiesManager.getDriverKey(), propertiesManager.getDriverPath());
        driver = new ChromeDriver();
        driver.get(propertiesManager.getUrl());
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(WAITING_TIME, TimeUnit.SECONDS);
        mainPageSteps = new MainPageSteps(driver);
    }

    public MainPageSteps getMainPageSteps() {
        return mainPageSteps;
    }

    public void closeBrowser() {
        driver.quit();
    }
}
