package com.sannikov.steps;

import com.sannikov.objects.MainPage;
import org.springframework.stereotype.Component;

@Component
public class MainPageSteps extends BasePageSteps {
    private static final ThreadLocal<MainPage> MAIN_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private MainPage getMainPage() {
        return MAIN_PAGE_THREAD_LOCAL.get();
    }

    public void setMainPage(MainPage mainPage) {
        MAIN_PAGE_THREAD_LOCAL.set(mainPage);
    }
}
