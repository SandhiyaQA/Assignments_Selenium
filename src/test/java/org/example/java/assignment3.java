package org.example.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment3 {
    public static void main(String[] args) {
        System.setProperty("web-driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
 driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        String id_FirstName = "input-firstname";
        String id_LastName = "input-lastname";
        String id_Email = "input-email";
        String id_Telephone = "input-telephone";
        String id_Password = "input-password";
        String id_ConfirmPwd = "input-confirm";
        String xpath_Newsletter = "(//input[@name='newsletter'])[1]";
        String name_Agree = "agree";
        String xpath_Continue = "//input[@value='Continue']";
        String xpath_Text = "//div[@id='content']//p";
        driver.findElement(By.id("input-firstname")).sendKeys("Ja2ck");
        driver.findElement(By.id("input-lastname")).sendKeys("RAM");
        driver.findElement(By.id("input-email")).sendKeys("Jackie2@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("12345678");
        driver.findElement(By.id("input-password")).sendKeys("Ja333ck");
        driver.findElement(By.id("input-confirm")).sendKeys("Ja333ck");
        driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        String am = driver.findElement(By.cssSelector("div#content")).getText();
        if (am.equals("congratulation")) {
            System.out.println("not match");
        } else {
            System.out.println("match");
        }
//    driver.close();
    }


}
