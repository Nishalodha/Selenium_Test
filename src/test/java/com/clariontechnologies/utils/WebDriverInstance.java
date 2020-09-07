package com.clariontechnologies.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum WebDriverInstance {
    INSTANCE;

    private WebDriver driver = build();

    private WebDriver build() {
        WebDriverManager.chromedriver().setup();
        // ChromeOptions option = new ChromeOptions();
        // option.addArguments("headless");
        driver = new ChromeDriver();
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
