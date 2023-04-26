package datadrivenpackage.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectFiles1 {

    WebDriver driver;
    public PageObjectFiles1(WebDriver d)
    {
        driver=d;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="user name")
    WebElement UserName;

    @FindBy(name="password")
    WebElement Password;

    @FindBy(name="submit")
    WebElement submit;


    public void setUserName( String userName,String password)

    {
    UserName.sendKeys(userName);
    Password.sendKeys(password);
    submit.click();
    }



    }



