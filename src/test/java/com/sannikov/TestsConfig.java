package com.sannikov;

import com.sannikov.core.BrowserManager;
import com.sannikov.core.ContextConfig;
import com.sannikov.core.PropertiesManager;
import com.sannikov.steps.MainPageSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

@ContextConfiguration(classes = ContextConfig.class)
public class TestsConfig extends AbstractTestNGSpringContextTests {

    private static final Logger logger = LoggerFactory.getLogger(TestsConfig.class);

    @Autowired
    protected BrowserManager browserManager;
    @Autowired
    protected MainPageSteps mainPageSteps;
    @Autowired
    private PropertiesManager propertiesManager;

    protected String loginName;
    protected String loginPassword;

    @BeforeClass
    public void webSettings() {
        loginName = propertiesManager.getName();
        loginPassword = propertiesManager.getPassword();
        browserManager.startBrowser();
        mainPageSteps.start();
        logger.info("BeforeClass is finish");
    }

    @AfterTest(alwaysRun = true)
    public void endOfTest() {
        browserManager.closeBrowser();
    }
}
