package pageObjectModelProject.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver d)
    {
        driver=d;
        PageFactory.initElements(driver,this);

    }
    @FindBy(name="emailid")
    WebElement email;


    public void setEmail(String mail)
    {
        email.sendKeys(mail);
    }

}