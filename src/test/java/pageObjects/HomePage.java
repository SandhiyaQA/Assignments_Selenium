package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
 WebDriver driver;
HomePage(WebDriver driver)
{
    this.driver=driver;
}

    By button=By.xpath("//a[contains(@href,\"sign_in\")]");


public void loginAutomation()

{
   driver.findElement(button).click();
}
}

