package org.example.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firstselenium {
    public static void main(String[] args) throws InterruptedException {
       System.setProperty("web driver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        WebDriver driver;
        driver = new FirefoxDriver();
       driver.get("https://www.firefox.com");
       Thread.sleep(5000);
        driver.close();
    }
}
