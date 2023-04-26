package pomaAndPageSeperate;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage1 {


@FindBy(id="user[email]")
public static WebElement userName;

@FindBy(id="user[password]")
static WebElement passWord;

@FindBy(xpath="//button[contains(text(),' Sign in')]")
static WebElement submit;


public static void login()
{
    userName.sendKeys("admin@gmail.com");
    passWord.sendKeys("admin123");
    submit.click();
}


 //

 }