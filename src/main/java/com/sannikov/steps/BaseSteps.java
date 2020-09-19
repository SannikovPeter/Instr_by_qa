package com.sannikov.steps;

import com.sannikov.core.AppContext;
import com.sannikov.core.BrowserManager;
import com.sannikov.objects.AbstractBase;
import com.sannikov.objects.elements.Header;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Component
public class BaseSteps {

    public static final int WAITING_TIME = 5;
    private static final Logger logger = LoggerFactory.getLogger(BaseSteps.class);

    public static WebDriver getDriver() {
        return AppContext.getBean(BrowserManager.class).getDriver();
    }

    public boolean isPageCorrect() {
        return false;
    }

    private void waitUntilBeClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(AbstractBase.getDriver(), WAITING_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    private void waitUntilBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(AbstractBase.getDriver(), WAITING_TIME);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void saveClick(WebElement element) {
        try {
            if (element != null) {
                waitUntilBeClickable(element);
                element.click();
            } else logger.info("Sorry, page or element is not exists");
        } catch (NullPointerException error) {
            logger.info("Sorry, element is not exists");
        }
    }

    public void moveTo(WebElement webElement) {
        waitUntilBeVisible(webElement);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(webElement).build().perform();
    }

    public double stringPriceToDouble(String price) {
        return Double.parseDouble(price.substring(0, price.length() - 4));
    }

    public <T extends WebElement> T isExistsReturnWebElement(T element) {
        T result;
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        Wait<WebDriver> wait = new FluentWait<>(getDriver()).withTimeout(WAITING_TIME, TimeUnit.SECONDS);
        Instant startTime = Instant.now();
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            result = element;
        } catch (TimeoutException | StaleElementReferenceException | NoSuchElementException e) {
            Instant endTime = Instant.now();
            Duration duration = Duration.between(startTime, endTime);
            logger.info(String.format("Element doesn't exist, time = %s ms", duration.toMillis()));
            result = null;
        }
        getDriver().manage().timeouts().implicitlyWait(WAITING_TIME, TimeUnit.SECONDS);

        return result;
    }

    public void scrollWindow(int y) {
        ((JavascriptExecutor) AbstractBase.getDriver()).executeScript("window.scrollBy(" + 0 + ","
                + y + ");");
    }

    public HeaderSteps getHeader() {
        HeaderSteps headerSteps = AppContext.getBean(HeaderSteps.class);
        headerSteps.setHeaderPage(AbstractBase.getPage(Header.class));
        return headerSteps;
    }
}
