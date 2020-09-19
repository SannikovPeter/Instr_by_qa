package com.sannikov.objects;

import com.sannikov.core.AppContext;
import com.sannikov.core.BrowserManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

@Component
public abstract class AbstractBase extends HtmlElement {

    public static WebDriver getDriver() {
        return AppContext.getBean(BrowserManager.class).getDriver();
    }

    public static <T extends AbstractBase> T getPage(Class<T> var1) {
        return HtmlElementLoader.create(var1, getDriver());
    }

    public String getURL() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return getWrappedElement().getRect();
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
