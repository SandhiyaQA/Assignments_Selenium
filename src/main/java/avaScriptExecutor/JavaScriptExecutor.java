package avaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

    public static void main(String[] args) {

        //setting up web browser
        System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();



        //Launching web browser
        driver.get("https://demo.guru99.com/test/delete_customer.php");

        //To maximize window size
        driver.manage().window().maximize();
        WebElement element= driver.findElement(By.name("submit"));

       /*
       //FLASH
        String bg=element.getCssValue("backgroundcolor");
        String bg1="#000000";
        JavascriptExecutor js=(JavascriptExecutor)driver;
        for(int i=0;i<200;i++)
        {
        js.executeScript("arguments[0].style.background='"+bg+"'",element);
js.executeScript("arguments[0].style.background='"+bg1+"'",element);
        //closing the web driver
            }


        //border
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='3px solid red'",element);




        //title
        JavascriptExecutor js=(JavascriptExecutor)driver;
        String s=js.executeScript("return document.title;").toString();
        System.out.println(s);


//click
        JavascriptExecutor js=(JavascriptExecutor)driver;

        js.executeScript("arguments[0].click();",element);

//alert

       // JavascriptExecutor js=(JavascriptExecutor)driver;
String message="you clicked submit button";
        js.executeScript("alert('"+message+"')");

//refresh
        JavascriptExecutor js=(JavascriptExecutor)driver;

        js.executeScript("history.go(0)");
*/

        //scroll page

        JavascriptExecutor js=(JavascriptExecutor)driver;

        js.executeScript("arguments[0].click();",element);












    }
}
