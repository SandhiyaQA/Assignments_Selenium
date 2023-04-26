package org.example.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sendk {
    //private static Object keys;

    public static void main(String[] args) {
        System.setProperty ("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
   WebDriver driver=new ChromeDriver();
   driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).clear();
   driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).clear();

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        Object keys;
        driver.findElement(By.id("login-button")).click();


        driver.quit();
    }
}
