package project001;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Project001 {
    public static void main(String[] args) throws InterruptedException, IOException {

        //setting up web browser
        System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //To maximize window size
        driver.manage().window().maximize();
        //Launching web browser
        driver.get("https://www.etmoney.com/");     //implicit wait to load web elemnets and to maintain synchronization
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        try{
            WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(4));
            WebElement widget=driver.findElement(By.xpath("//div[@class='widget-content']//div/span/img"));
        if(wait1.until(ExpectedConditions.elementToBeClickable(widget))==null)

            {
                System.out.println("not dfouf");
                }
        else {
            //driver.switchTo().alert();
            System.out.println("element clicked");
            driver.findElement(By.xpath("//div[@class='widget-content']//div/span/img")).click();

        }

        }
        catch (Exception e)

        {
         e.printStackTrace();
        }




       //Mutual fund click
        WebElement mutualFund = driver.findElement(By.xpath("//span[text()='Mutual Funds ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mutualFund).perform();


        //dropdown and click to click equity fund
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='dropdown-block'][1]/ul/li"));
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            String actual = list.get(i).getText();
            if (actual.equals("Equity funds")) {
                list.get(i).click();
                break;
            }
        }


        //list elements ubder diversification
        List<WebElement> Diversification = driver.findElements(By.xpath("//div//Strong[text()='By Diversification']//parent::div/div/ul/li"));
//        System.out.println(Diversification.size());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,400)");

        //click focused
        for (int i = 0; i < Diversification.size(); i++) {
            String Actial = Diversification.get(i).getText();
            if (Actial.startsWith("Focused")) {
                Diversification.get(i).click();
                break;
            }
        }


        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scroll(0,200)");

        //list of funds
        List<String> link2 = new ArrayList<>();
        List<WebElement> link = driver.findElements(By.xpath("//div[@id='fundListing']//a"));

        for (int i = 0; i < link.size(); i++) {
            if (!link.get(i).getText().equalsIgnoreCase("know more")) {
                link2.add(link.get(i).getText());
                i = i + 1;
            }
        }
////div[@id='fundListing']//div[@class='fund-name scheme-name']//a

        //before sorting size of funds
        int before = link2.size();
        System.out.println("Fund count before sort" + link2.size());
        System.out.println();
        //clcik sorting
        driver.findElement(By.xpath("//button[@id='sorting-mode']")).click();


        //findind list of sort options
        List<WebElement> sortOption = driver.findElements(By.xpath("//div[@id='sorting-mode-dropdown']/div/div/div/ul/li"));
        for (int i = 0; i < sortOption.size(); i++) {
            System.out.println(sortOption.get(i).getText() + "" + sortOption.size());
            if (sortOption.get(i).getText().contains("VRO")) {
                sortOption.get(i).click();
                break;
            }
        }


        //snapshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File desc = new File("C://Users//Dell//IdeaProjects//mavenpro//screenshot1//screen.png");
        //FileUtils.copyFile(src, desc);

        FileHandler.copy(src,desc);

        //after sort

        List<WebElement> link4 = driver.findElements(By.xpath("//div[@id='fundListing']/div"));
        int after=link4.size();
//        System.out.println("Funds");
//        for(int i=0;i<link4.size();i++)
//        {
//            System.out.println((i+1)+"    "+link4.get(i).getText());
//        }
//        System.out.println();
        //verification of number of funds before and after sorting
        Assert.assertEquals(before,after,"Number of records are not same as previous");
        System.out.println("Number of records are same as before");
        System.out.println();
        //List of returns values
        List<WebElement>  returnInvestment = driver.findElements(By.xpath("//div[@class='fundInfo']/div/following-sibling::div/div[2]/div[2]/p//strong[contains(@class,'active')]"));
        System.out.println("Returns");
        for(int i=0;i<returnInvestment.size();i++)
{
    System.out.println(i+1+"   "+returnInvestment.get(i).getText());

}
        System.out.println();
        //one fund is missing
        //missing fund details(1)
        WebElement return2=driver.findElement(By.xpath("//div[@class='fundInfo']/div/following-sibling::div/div[3]/div[2]/p//strong[contains(@class,'active')]"));
        returnInvestment.add(1,return2);

        //onvert webelements to float for calculation
        List returnOn=new ArrayList<>();
       String webString=null;
        for(int i=0;i<returnInvestment.size();i++) {
            webString = returnInvestment.get(i).getText();
            if(webString.equalsIgnoreCase("N.A."))
            {
                returnOn.add(Float.parseFloat(webString.replace("N.A.","0.0")));

            }
            else if(!(webString.equals("0.0")||(webString.equals("N.A.")||webString.length()==0))           ) {
                returnOn.add(Float.parseFloat(webString.substring(2,6).replace("%","")));

            }
        }



        //list of ratings
        List<WebElement>  rating = driver.findElements(By.xpath("//div[@class='fundInfo']/div/following-sibling::div/div[3]/p/following-sibling::span"));
        System.out.println("Ratings");
        for(int i=0;i< rating.size();i++)
       {
           System.out.println(i+1+"  "+ rating.get(i).getText());
       }
        System.out.println();
        List<Integer> ratingInInteger=new ArrayList<>();
         for(int i=0;i<rating.size();i++)
        {
            String ratings=rating.get(i).getText();

          if((ratings.equalsIgnoreCase("N.A.")||(ratings.equalsIgnoreCase(""))))
          {
              rating.get(i).getText().replace("","0");

          }

          //converting to integer(optional this step we can stright way print string form of ratings
          else if(!ratings.equalsIgnoreCase("N.A.")) {
              ratingInInteger.add(Integer.parseInt(ratings));
          }
        }

         //as one element is missing/empty so i added 0
        ratingInInteger.add(1,0);
         Iterator<Integer> itr2=ratingInInteger.iterator();
         while(itr2.hasNext())
         {
       //      System.out.println(itr2.next());
         }


         //printing values  which are >15%
        System.out.println("Funds"+"                                            "+"Returns>15%" +"      "+"star_rating");
         for(int i=0;i<returnOn.size();i++)
         {
             Float compare= (Float) returnOn.get(i);
             if(compare>15.0)

             {
                 System.out.println(link2.get(i)+"                             "+returnOn.get(i)+"      "+ratingInInteger.get(i)+ "*");
                 System.out.println();
             }
         }


         //closing browser
driver.close();
    }
}