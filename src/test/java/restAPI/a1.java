package restAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class a1 {
    @Test
    public void rest() throws AWTException, IOException {
        Response re= RestAssured.get("https://reqres.in/api/unknown/1");
        System.out.println(re.toString());
        System.out.println(re.prettyPrint());

        Robot robot=new Robot();
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle r=new Rectangle(d);
        BufferedImage image = robot.createScreenCapture(r);
        File des=new File("");
        ImageIO.write(image,"png",des);

        //File file=new File("");
//        download.click;
//        String f="";
//        StringSelection s=new StringSelection(f);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
//        Robot robot1=new Robot();
//        robot1.keyPress(KeyEvent.VK_ENTER);


        //Download
        File file=new File("");
        File[] ff=file.listFiles();
        for(File fff:ff)
        {
            System.out.println(fff.getName().equals(""));
            System.out.println("present");
            break;

        }




    }}