package datadrivenpackage.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectRepository {
WebDriver driver;

    public PageObjectRepository(WebDriver d)
    {
        driver=d;
        PageFactory.initElements(driver,this);

    }
@FindBy(xpath="//input[@type='text']")
    WebElement username;

    @FindBy(xpath="//input[@type='password']")
    WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    WebElement clickm;


    public void setUsername(String user)
    {
        username.sendKeys(user);
    }

       public void setPassword(String pass)
       {
           password.sendKeys(pass);
       }


    public void clickmethod1() {
clickm.click();
    }
}
