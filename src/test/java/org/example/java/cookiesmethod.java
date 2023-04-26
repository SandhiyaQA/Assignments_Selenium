package org.example.java;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class cookiesmethod {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.google.com");
        Set<Cookie> cookies= driver.manage().getCookies();
        System.out.println(cookies);
        Cookie c=driver.manage().getCookieNamed("OGPC");
        System.out.println(c);
        Cookie cokk=new Cookie("software","tester");
        driver.manage().addCookie(cokk);
        Cookie c1=driver.manage().getCookieNamed("software");
        System.out.println(c1);
        driver.manage().deleteCookieNamed("software");
        Set<Cookie> c3=driver.manage().getCookies();
        System.out.println(c3);

    }
}
