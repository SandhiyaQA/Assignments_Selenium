package pageFactoryAndPom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage3 {


@FindBy(xpath="//a[contains(@href,\"sign_in\")]")
public static WebElement button;




public static void loginAutomation() {
    button.click();
}
}

