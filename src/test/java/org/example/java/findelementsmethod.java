package org.example.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class findelementsmethod {
    public static void main(String[] args) {
        System.setProperty("web driver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.naukri.com");
        String s=driver.getWindowHandle();
        System.out.println(s);
        Set<String> e=driver.getWindowHandles();
        for(String e1:e) {
            System.out.println(e1);
        }/*
        List<WebElement> element=driver.findElements(By.tagName("a"));
        for(WebElement e:element)
        {
            System.out.println(e.getText());
        }*/
        }
    }

