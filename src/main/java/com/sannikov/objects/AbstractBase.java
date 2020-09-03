package com.sannikov.objects;

import com.sannikov.core.AppContext;
import com.sannikov.core.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractBase {

    public static WebDriver getDriver() {
        return AppContext.getBean(BrowserManager.class).getDriver();
    }

    public static <T extends AbstractBase> T getPage(Class<T> var1) {
        return PageFactory.initElements(getDriver(), var1);
    }
}
