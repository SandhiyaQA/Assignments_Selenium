package org.example.java;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class desel {
    public static void main(String[] args) {
        System.setProperty("web driver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        Set<Cookie> cookies= driver.manage().getCookies();
        System.out.println(cookies);
        driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");
    WebElement element=(WebElement)driver.findElements(By.name("FromLB"));
        Select select=new Select(element);
        select.selectByValue("USA");
        select.selectByIndex(3);
        select.deselectByVisibleText("Russia");
    }

}
