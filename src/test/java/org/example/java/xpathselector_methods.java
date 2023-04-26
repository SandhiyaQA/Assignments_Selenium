package org.example.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathselector_methods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//a[contains(@href,'contact')]")).click();



    }
}
