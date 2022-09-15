package com.mtnplay.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Glob_LoginPage extends BasePage{

    public Glob_LoginPage(WebDriver newDriver, WebDriverWait newWait) {
        super(newDriver, newWait);
    }

    public void OpenPage() throws Exception {

        if (System.getProperty("env").equals("sit")) {
            webDriver.get("https://app.sit.mtnplay.com/");
            System.out.println("Opening - https://app.sit.mtnplay.com");
        }else if (System.getProperty("env").equals("dev")) {
            webDriver.get("https://app.dev.mtnplay.com");
            System.out.println("Opening - https://app.dev.mtnplay.com");
        }

    }
}
