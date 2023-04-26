package modularFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSuccessPage {

    WebDriver driver;

    public LoginSuccessPage(WebDriver d)
    {
        driver = d;
    }

    public static WebElement loginSuccessPage(WebDriver driver)
    {
        WebElement success=driver.findElement(By.xpath("//h3[text()='Login Successfully']"));
        return success;
    }
}
