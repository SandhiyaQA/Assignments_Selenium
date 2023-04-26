package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPage {

WebDriver driver;
LogOutPage(WebDriver driver){
    this.driver=driver;
}

By signOut= By.xpath("//a[contains(@href,'enrollments')]/parent::li/following::button");
By getSignOut=By.xpath("//a[contains(text(),'Sign Out')]");


    public  void setSignOut()
    {
    driver.findElement(signOut).click();
    driver.findElement(getSignOut).click();
    }
}
