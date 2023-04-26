package pageObjectModelProject.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginSuccessPage {

    WebDriver driver;
    public LoginSuccessPage(WebDriver d) {
        driver = d;
        PageFactory.initElements(driver, this);
    }


    @FindBy(how= How.XPATH,using = "//h3[text()='Login Successfully']")
    WebElement success;

public void validateSuccessPage()
{
    String actualmessage="Login Successfully";
    String expectedmessage=success.getText();
    Assert.assertEquals(actualmessage,expectedmessage,"TESTCASE FAILED");
    System.out.println(expectedmessage);
}
}
