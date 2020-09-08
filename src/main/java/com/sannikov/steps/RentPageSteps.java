package com.sannikov.steps;

import com.sannikov.objects.RentPage;
import org.springframework.stereotype.Component;

@Component
public class RentPageSteps extends BaseSteps {
    private static final ThreadLocal<RentPage> RENT_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private RentPage getRentPage() {
        return RENT_PAGE_THREAD_LOCAL.get();
    }

    public void setRentPage(RentPage rentPage) {
        RENT_PAGE_THREAD_LOCAL.set(rentPage);
    }

}
