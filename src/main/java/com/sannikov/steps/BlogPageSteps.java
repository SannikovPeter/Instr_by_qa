package com.sannikov.steps;

import com.sannikov.objects.pages.BlogPage;
import org.springframework.stereotype.Component;

@Component
public class BlogPageSteps extends BaseSteps {

    private static final ThreadLocal<BlogPage> BLOG_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private BlogPage getBlogPage() {
        return BLOG_PAGE_THREAD_LOCAL.get();
    }

    public void setBlogPage(BlogPage blogPage) {
        BLOG_PAGE_THREAD_LOCAL.set(blogPage);
    }
}
