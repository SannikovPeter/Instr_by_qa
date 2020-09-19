package com.sannikov.steps;

import com.sannikov.objects.AbstractBase;
import com.sannikov.objects.pages.MainPage;
import org.springframework.stereotype.Component;

@Component
public class MainPageSteps extends BaseSteps {
    private static final ThreadLocal<MainPage> MAIN_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private MainPage getMainPage() {
        return MAIN_PAGE_THREAD_LOCAL.get();
    }

    public void setMainPage(MainPage mainPage) {
        MAIN_PAGE_THREAD_LOCAL.set(mainPage);
    }

    public void start() {
        setMainPage(AbstractBase.getPage(MainPage.class));
    }

}
