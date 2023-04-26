package org.keyword_driven.java.org.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testcase {
    public static void main(String[] args) {

        //open browser
        System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //go to url
        driver.get("https://demo.guru99.com/V1/index.php");

        //To maximize window size
        driver.manage().window().maximize();

        //enter username

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mngr476387");

        //enter password

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("naretam");



        //click login

        driver.findElement(By.name("btnlogin")).click();



        // click logout  ////a[text()='Log out']


    }
}