package testngVerify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGverifyBase {

@Test
    public WebDriver initiation() {
    System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

    ChromeOptions option=new ChromeOptions();
    option.addArguments("--remote-allow-origins=*");

     return new ChromeDriver(option);


    }

    @Test
    public  void login(WebDriver d)
    {
        d.findElement(By.cssSelector("input#username")).sendKeys("student");
        d.findElement(By.cssSelector("input#password")).sendKeys("Password123");
        d.findElement(By.cssSelector("button#submit")).click();

    }
    @Test
    public   void verifyURLHardAssert(WebDriver d)
    {
        String currentURL=d.getCurrentUrl();
        String ExpectedURL="https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(currentURL,ExpectedURL,"No Matches found in URL");
        String expectedMessage="Logged In Successfully";
        String actualMessage=d.findElement(By.xpath("//h1[text()=\"Logged In Successfully\"]")).getText();
        Assert.assertTrue(expectedMessage.contains(actualMessage),"no match found  in login success page");


    }

    @Test
    public   void verifyURLSoftAssert(WebDriver d)
    {
        SoftAssert asset=new SoftAssert();
        String currentURL=d.getCurrentUrl();
        String ExpectedURL="https://practicetestautomation.com/logged-in-successfully/";
        asset.assertEquals(currentURL,ExpectedURL,"No Matches found in URL");
        String expectedMessage="Logged In Successfully";
        String actualMessage=d.findElement(By.xpath("//h1[text()=\"Logged In Successfully\"]")).getText();
        asset.assertTrue(expectedMessage.contains(actualMessage),"no match found  in login success page");
        asset.assertAll();

    }


}