package steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseSteps {

    private static final int DEFAULT_TIME = 10;

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME));
        actions = new Actions(driver);
    }

    public void waitUntilBeClickableAndClick(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public void waitUntilBeVisible(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void moveTo(WebElement webElement) {
        waitUntilBeVisible(webElement);
        actions.moveToElement(webElement).build().perform();
    }

    public void moveToElementAndClick(WebElement webElement) {
        actions.moveToElement(webElement).click().build().perform();
    }

    public double stringPriceToDouble(String price) {
        return Double.parseDouble(price.substring(0, price.length() - 4));
    }

    public void scrollWindow(int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + 0 + ","
                + y + ");");
    }

}
