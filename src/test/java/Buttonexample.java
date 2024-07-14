import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class Buttonexample {

    WebDriver driver;
    @BeforeMethod
    public  void pubclz(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("122");
        driver = new ChromeDriver(chromeOptions);
        Dimension newSize = new Dimension(800, 900);
        driver.manage().window().setSize(newSize);

//        driver.manage().window().maximize();
        driver.get("https://leafground.com/button.xhtml");

    }
    @Test
    public  void btncheck(){

//        Click and Confirm title.
      WebElement btnID = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
      btnID.click();
      String actualTitle = driver.getTitle();
      String expectedTitle = "Dashboard";
      if (expectedTitle.equals(actualTitle)){
          System.out.println("correct");
      }
      driver.navigate().back();
//        Find the position of the Submit button
      WebElement x =  driver.findElement(By.id("j_idt88:j_idt94"));
      Point xyPonit = x.getLocation();
 int xcordinate = xyPonit.getX();
 int ycordinate = xyPonit.getY();
        System.out.println("x is " + xcordinate + "y is" + ycordinate);

//        Find the Save button color
      WebElement col = driver.findElement(By.id("j_idt88:j_idt96"));
    String val = col.getCssValue("background-color");
        System.out.println("color is " + val);

//Find the height and width of this button
WebElement dc = driver.findElement(By.id("j_idt88:j_idt98"));
int height = dc.getSize().getHeight();
int width = dc.getSize().getWidth();
    }

}
