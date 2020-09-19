package com.sannikov.steps;

import com.sannikov.objects.pages.ServicePage;
import org.springframework.stereotype.Component;

@Component
public class ServicePageSteps extends BaseSteps {
    private static final ThreadLocal<ServicePage> SERVICE_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private ServicePage getServicePage() {
        return SERVICE_PAGE_THREAD_LOCAL.get();
    }

    public void setServicePage(ServicePage servicePage) {
        SERVICE_PAGE_THREAD_LOCAL.set(servicePage);
    }
}
