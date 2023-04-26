package modularFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {
    WebDriver driver;


    public PageObjects(WebDriver d)
    {
        driver=d;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath="//input[@name='emailid']")
    public static WebElement email;
    @FindBy(xpath="//input[@name='btnLogin']")
    public static WebElement submit;

    @FindBy(xpath="//a[text()='New Tours']")
    public static WebElement newTour;
    @FindBy(xpath="//input[@name='userName']")
    public static WebElement username;
    @FindBy(xpath="//input[@name='password']")
    public static WebElement password;

   @FindBy(how= How.XPATH,using = "//h3[text()='Login Successfully']")
    public static WebElement success;
}
