package modularFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TourPage {
    WebDriver driver;

    public TourPage(WebDriver d)
    {
        driver = d;
    }

    public static WebElement tourPage(WebDriver driver)
    {
        WebElement tour=driver.findElement(By.xpath("//a[text()='New Tours']"));
        return tour;
    }
}