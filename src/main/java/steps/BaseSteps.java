package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Base;

import java.time.Duration;

public class BaseSteps {
    private static final int DEFAULT_TIME = 10;
    private WebDriver driver;
    private Base base;
    private WebDriverWait wait;
    private Actions actions;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
        base = PageFactory.initElements(driver, Base.class);
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME));
        actions = new Actions(driver);
    }

    public void waitUntilBeClickableAndClick(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public void waitUntilInvisibly(WebElement webElement) {
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public void moveTo(WebElement webElement) {
        actions.moveToElement(webElement).build().perform();
    }

    public void moveToElementAndClick(WebElement webElement) {
        actions.moveToElement(webElement).click().build().perform();
    }

}
