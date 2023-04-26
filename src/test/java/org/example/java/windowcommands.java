package org.example.java;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowcommands {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
     driver.get("https://google.com");
        driver.manage().window().maximize();
   driver.manage().window().fullscreen();
        Point point=driver.manage().window().getPosition();
        System.out.println(point.x);
        System.out.println(point.y);

    }
}
