package modularFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver d)
    {
        driver=d;
    }
    public static WebElement emailId(WebDriver driver)
    {
       WebElement email= driver.findElement(By.name("emailid"));
       return email;

    }

    public static WebElement submit1(WebDriver driver) {

        WebElement submit1=driver.findElement(By.xpath("//input[@name='btnLogin']"));
    return submit1;
    }




}