package org.example.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class selectmehod {
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
     WebElement element= driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select=new Select(element);    select.selectByValue("Price (high to low)"); }
}
