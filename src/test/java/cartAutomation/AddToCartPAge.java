package cartAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddToCartPAge {
    WebDriver driver;

    AddToCartPAge(WebDriver d) {

        driver = d;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a//div[1]")
    WebElement product1;

    @FindBy(xpath="//a[@id='item_0_title_link']")
    WebElement product2;

public void verifyAddCart() throws InterruptedException {
    String pro1=product1.getText();
    Thread.sleep(3000);
    String pro2=product2.getText();


    Assert.assertEquals(pro1,"Sauce Labs Backpack");
    Assert.assertEquals(pro2,"Sauce Labs Bike Light");
    System.out.println("Items added Successfully");
}

}