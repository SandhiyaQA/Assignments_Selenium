package modularFramework.modules;

import modularFramework.pageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class Modules {

WebDriver webdriver;
public Modules(WebDriver d)
{
    webdriver=d;

}


    public  void setEmail()
    {
        HomePage.emailId(webdriver).sendKeys("sandhiyaravi01@gmail.com");
        HomePage.submit1(webdriver).click();
    }
    public void validateSuccessPage()
    {
        String actualmessage="Login Successfully";
        String expectedmessage= LoginSuccessPage.loginSuccessPage(webdriver).getText();
        Assert.assertEquals(actualmessage,expectedmessage,"TESTCASE FAILED");
        System.out.println(expectedmessage);
    }
    public void clickNewTour(WebDriver driver)
    {

        Actions action=new Actions(driver);
        action.moveToElement(TourPage.tourPage(webdriver)).click().perform();

    }
    public void login()
    {
        WelcomeLoginPage.userName(webdriver).sendKeys("sandhiya");
        WelcomeLoginPage.passWord(webdriver).sendKeys("sandhiya");
        WelcomeLoginPage.submitLogin(webdriver).click();
    }

}


