package com.sannikov.steps;

import com.sannikov.objects.AboutUsPage;
import org.springframework.stereotype.Component;

@Component
public class AboutUsPageSteps extends BasePageSteps {
    private static final ThreadLocal<AboutUsPage> ABOUT_US_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private AboutUsPage getAboutUsPageThreadLocal() {
        return ABOUT_US_PAGE_THREAD_LOCAL.get();
    }

    public void setAboutUsPage(AboutUsPage aboutUsPage){
        ABOUT_US_PAGE_THREAD_LOCAL.set(aboutUsPage);
    }

}
