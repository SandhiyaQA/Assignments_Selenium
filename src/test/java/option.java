import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class option {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
        driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");
        //WebElement element=(WebElement) driver.findElements(By.name("FromLB"));
        WebElement element= driver.findElement(By.name("FromLB"));
        Select select=new Select(element);
    //    driver.findElement(By.id("radio1")).click();
    select.selectByIndex(1);
        select.selectByIndex(2);
        List<WebElement> options=select.getOptions();
        System.out.println("get options");
        for(WebElement e:options)
   {
       System.out.println(e.getText());

   }
        System.out.println("getfirstoptions");
   WebElement firstSelectedOptions= select.getFirstSelectedOption();
        System.out.println(firstSelectedOptions.getText());
        System.out.println("getallselected options:");
        List<WebElement> selectedoptions=select.getAllSelectedOptions();
   for(WebElement e:selectedoptions){
       System.out.println(e.getText());
   }

  //  driver.close();
    }

}
