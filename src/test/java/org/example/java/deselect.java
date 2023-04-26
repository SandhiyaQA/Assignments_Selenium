package org.example.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class deselect {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");
        WebElement element=driver.findElement(By.name("FromLB"));
//        WebElement element = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(element);
        select.selectByValue("Russia");
        select.selectByIndex(4);
        select.selectByVisibleText("USA");
        select.deselectByIndex(4);
        select.deselectByIndex(4);
        select.deselectByVisibleText("USA");
        select.selectByIndex(5);
        select.deselectAll();

//
    }
}