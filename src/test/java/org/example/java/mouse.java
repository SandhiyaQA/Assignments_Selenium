package org.example.java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouse {
    public static void main(String[] args) {
        System.setProperty("web-driver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
       /* WebElement element=driver.findElement(By.id("input-firstname"));
        Actions actions=new Actions(driver);

        actions.moveToElement(element).click(element).sendKeys("sandhiya").doubleClick(element).contextClick(element).build().perform();
  */ WebElement element1=driver.findElement(By.id("input-lastname"));
   Actions actions1=new Actions(driver);
   actions1.keyDown(Keys.SHIFT).sendKeys(element1,"sandhiya").build().perform();
    }
}
