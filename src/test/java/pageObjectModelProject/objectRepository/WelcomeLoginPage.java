package pageObjectModelProject.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomeLoginPage {

    WebDriver driver;
    public WelcomeLoginPage(WebDriver d) {
        driver = d;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@name='userName']")
    WebElement username;


    @FindBy(xpath="//input[@name='password']")
    WebElement password;


    @FindBy(xpath="//input[@name='submit']")
    WebElement submit;
    public void setUsername(String name)
    {
        username.sendKeys(name);
    }
    public void setPassword(String pass)
    {
        password.sendKeys(pass);
    } public void setSubmit()
    {
        submit.click();
    }



}
