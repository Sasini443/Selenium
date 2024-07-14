import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {

    WebDriver driver;

    @BeforeMethod
    public void radiobtncheck(){
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(1200,1000);
        driver.manage().window().setSize(newSize);
        driver.get("https://leafground.com/frame.xhtml");


    }
    @Test
    public void testFrame(){
//Click Me (Inside frame)
        driver.switchTo().frame(0);
      WebElement btn = driver.findElement(By.xpath("//button[@id='Click']"));
      btn.click();
      String txt = btn.getText();
      if(txt.equals("Hurray! You Clicked Me.")){
          System.out.println("success");
      }
//How many frames in this page?
driver.switchTo().defaultContent();
        List<WebElement> xy =   driver.findElements(By.tagName("iframe"));
     int a=   xy.size();
        System.out.println(a);

//Click Me (Inside Nested frame)
        driver.switchTo().defaultContent();
      driver.switchTo().frame(2);
      driver.switchTo().frame(0);
        WebElement btn1 = driver.findElement(By.xpath("//button[@id='Click']"));
        btn1.click();
        String txt1 = btn1.getText();
        if(txt1.equals("Hurray! You Clicked Me.")){
            System.out.println("success");
        }
    }


}
