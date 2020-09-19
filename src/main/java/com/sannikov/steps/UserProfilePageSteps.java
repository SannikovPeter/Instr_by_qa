package com.sannikov.steps;

import com.sannikov.objects.AbstractBase;
import com.sannikov.objects.pages.UserProfilePage;
import org.springframework.stereotype.Component;

@Component
public class UserProfilePageSteps extends BaseSteps {
    private static final ThreadLocal<UserProfilePage> USER_PROFILE_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private UserProfilePage getUserProfilePage() {
        return USER_PROFILE_PAGE_THREAD_LOCAL.get();
    }

    public void setUserProfilePage(UserProfilePage userProfilePage) {
        USER_PROFILE_PAGE_THREAD_LOCAL.set(userProfilePage);
    }

    public boolean isPageCorrect() {
        return getUserProfilePage().getURL().equals(AbstractBase.getDriver().getCurrentUrl());
    }
}
