package com.sannikov.steps;

import com.sannikov.objects.AbstractBase;
import com.sannikov.objects.pages.ConstructionAndRepairBlogPage;
import org.springframework.stereotype.Component;

@Component
public class ConstructionAndRepairBlogSteps extends BaseSteps {

    private static final ThreadLocal<ConstructionAndRepairBlogPage> CONSTRUCTION_AND_REPAIR_BLOG_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private ConstructionAndRepairBlogPage getConstructionAndRepairBlogPage() {
        return CONSTRUCTION_AND_REPAIR_BLOG_PAGE_THREAD_LOCAL.get();
    }

    public void setConstructionAndRepairBlogPage(ConstructionAndRepairBlogPage constructionAndRepairBlogPage) {
        CONSTRUCTION_AND_REPAIR_BLOG_PAGE_THREAD_LOCAL.set(constructionAndRepairBlogPage);
    }

    public boolean isPageCorrect() {
        return getConstructionAndRepairBlogPage().getURL().equals(AbstractBase.getDriver().getCurrentUrl());
    }
}
