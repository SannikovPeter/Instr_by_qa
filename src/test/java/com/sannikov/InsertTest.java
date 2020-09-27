package com.sannikov;

import com.sannikov.steps.LoginPageSteps;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InsertTest extends TestConfig {

    private LoginPageSteps loginPageSteps;

    @BeforeMethod
    public void checkLogOut() {
        mainPageSteps.getHeader().logOutIfItNecessary();
        loginPageSteps = mainPageSteps.getHeader().goToLoginPage();
    }

    @AfterMethod
    public void endTest() {
        mainPageSteps.getHeader().backToMainPage();
    }


    @Test
    public void checkOpenLoginPage() {
        Assert.assertTrue(loginPageSteps.isPageCorrect());
    }

    @Test
    public void successInsertTest() {
        Assert.assertTrue(loginPageSteps.successLogin(loginName, loginPassword).isPageCorrect());
    }

    @Test
    public void unsuccessfulInsertTest() {
        String wrongName = "Name";
        String wrongPassword = "1234";

        Assert.assertTrue(loginPageSteps.unsuccessfulLogin(wrongName, wrongPassword).isAlertPresent());
    }

    @AfterClass(alwaysRun= true)
    public void endInsertTest(){
        browserManager.closeBrowser();
    }

}
