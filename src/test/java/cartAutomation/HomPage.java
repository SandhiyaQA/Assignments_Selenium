package cartAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomPage {
    public static WebDriver driver;
    HomPage(WebDriver d)
    {
        driver=d;
        PageFactory.initElements(driver,this);
    }
    @FindAll({
       @FindBy(id ="user-name"),
       @FindBy(name="user-name")
})
WebElement userName;


            @FindBy(id = "password")
         WebElement password;



        @FindBy(id = "login-button")
        WebElement submit;


public void login()
{
userName.sendKeys("standard_user");
password.sendKeys("secret_sauce");
submit.click();

}}
