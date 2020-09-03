package com.sannikov.steps;

import com.sannikov.objects.BlogPage;
import org.springframework.stereotype.Component;

@Component
public class BlogPageSteps extends BasePageSteps {

    private static final ThreadLocal<BlogPage> BLOG_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private BlogPage getBlogPage() {
        return BLOG_PAGE_THREAD_LOCAL.get();
    }

    public void setBlogPage(BlogPage blogPage) {
        BLOG_PAGE_THREAD_LOCAL.set(blogPage);
    }
}