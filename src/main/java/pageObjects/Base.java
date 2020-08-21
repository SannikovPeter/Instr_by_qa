package pageObjects;

import core.AppContext;
import core.BrowserManager;
import org.openqa.selenium.support.PageFactory;

public class Base {

    private final BrowserManager browserManager;

    public Base() {
        browserManager = AppContext.getBean(BrowserManager.class);
        PageFactory.initElements(browserManager.getDriver(), this);
    }
}
