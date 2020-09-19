package com.sannikov.steps;

import com.sannikov.objects.pages.AboutUsPage;
import org.springframework.stereotype.Component;

@Component
public class AboutUsPageSteps extends BaseSteps {
    private static final ThreadLocal<AboutUsPage> ABOUT_US_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private AboutUsPage getAboutUsPageThreadLocal() {
        return ABOUT_US_PAGE_THREAD_LOCAL.get();
    }

    public void setAboutUsPage(AboutUsPage aboutUsPage) {
        ABOUT_US_PAGE_THREAD_LOCAL.set(aboutUsPage);
    }

}
