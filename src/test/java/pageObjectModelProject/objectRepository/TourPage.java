package pageObjectModelProject.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TourPage {
WebDriver driver;
public TourPage(WebDriver d)
{
    driver=d;
    PageFactory.initElements(driver,this);
}
    @FindBy(xpath="//a[text()='New Tours']")
    WebElement newTour;
    /*@FindBy (xpath = "//div[@id='dismiss-button']")
    WebElement ads;
    */

    public void clickNewTour(WebDriver driver)
    {

       Actions action=new Actions(driver);
        action.moveToElement(newTour).click().perform();

    }
}
