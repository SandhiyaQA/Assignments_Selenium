package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

WebDriver driver;
LoginPage(WebDriver driver)
{
    this.driver=driver;
}


By userName= By.id("user[email]");
By passWord=By.id("user[password]");

By submit=By.xpath("//button[contains(text(),' Sign in')]");



public  void login()
{
driver.findElement(userName).sendKeys("admin@gmail.com");
    driver.findElement(passWord).sendKeys("admin123");
    driver.findElement(submit).click();

}


 //

 }