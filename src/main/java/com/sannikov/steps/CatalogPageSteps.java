package com.sannikov.steps;

import com.sannikov.objects.AbstractBase;
import com.sannikov.objects.CatalogPage;
import org.springframework.stereotype.Component;

@Component
public class CatalogPageSteps extends BasePageSteps {
    private static final ThreadLocal<CatalogPage> CATALOG_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private CatalogPage getCatalogPage() {
        return CATALOG_PAGE_THREAD_LOCAL.get();
    }

    public void setCatalogPage(CatalogPage catalogPage) {
        CATALOG_PAGE_THREAD_LOCAL.set(catalogPage);
    }

    @Override
    public boolean isPageCorrect() {
        return getCatalogPage().getURL().equals(AbstractBase.getDriver().getCurrentUrl());
    }
}
