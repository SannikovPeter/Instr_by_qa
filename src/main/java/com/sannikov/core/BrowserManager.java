package com.sannikov.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class BrowserManager {

    private static final Logger logger = LoggerFactory.getLogger(BrowserManager.class);
    private static final int WAITING_TIME = 10;
    @Autowired
    private PropertiesManager propertiesManager;
    private WebDriver driver;

    public void startBrowser() {
        System.setProperty(propertiesManager.getDriverKey(), propertiesManager.getDriverPath());
        driver = new ChromeDriver();
        driver.get(propertiesManager.getUrl());
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(WAITING_TIME, TimeUnit.SECONDS);
        logger.info("BrowserManager is loaded");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeBrowser() {
        driver.quit();
    }
}
