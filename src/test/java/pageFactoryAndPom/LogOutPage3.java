package pageFactoryAndPom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage3 {


    @FindBy(xpath="//a[contains(@href,'enrollments')]/parent::li/following::button")
   static WebElement signOut;

    @FindBy(xpath="//a[contains(text(),'Sign Out')]")
    static WebElement getSignOut;


    public static void setSignOut()
    {
       signOut.click();
       getSignOut.click();

}}
