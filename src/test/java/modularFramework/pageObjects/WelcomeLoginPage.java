package modularFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomeLoginPage {

    WebDriver driver;
    public WelcomeLoginPage(WebDriver d) {
        driver = d;

    }

    public static WebElement userName(WebDriver d) {
       WebElement uname= d.findElement(By.xpath("//input[@name='userName']"));
        return  uname;
    }
    public static WebElement passWord(WebDriver d) {
      WebElement pass=d.findElement(By.xpath("//input[@name='password']"));
        return pass;
    }
    public static WebElement submitLogin(WebDriver d) {
       WebElement submit2= d.findElement(By.xpath("//input[@name='submit']"));
        return submit2;
    }

    }
