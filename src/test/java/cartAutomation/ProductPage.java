package cartAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    ProductPage(WebDriver d) {
        driver = d;
        PageFactory.initElements(driver, this);
    }

    @FindBys({
            @FindBy(css = "#add-to-cart-sauce-labs-backpack"),
            @FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-backpack']")
    })
    WebElement product1;


    @FindBy(css = "#add-to-cart-sauce-labs-bike-light")
    WebElement product2;


    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement addCart;

    public void clickProduct() {
        product1.click();
        product2.click();
        addCart.click();
    }
}
