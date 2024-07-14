import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AltertExamplle {

    WebDriver driver;

    @BeforeMethod
    public void radiobtncheck(){
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(1200,1000);
        driver.manage().window().setSize(newSize);
        driver.get("https://leafground.com/alert.xhtml");


    }
    @Test
    public void alertTest(){
//        alert shows
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']")).click();
        Alert a = driver.switchTo().alert();
        a.accept();


//        Alert (Confirm Dialog)
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']")).click();
       Alert B= driver.switchTo().alert();
       B.dismiss();

//       Alert (Prompt Dialog)
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt104']")).click();
        Alert C= driver.switchTo().alert();
        C.sendKeys("Sasini");
        C.accept();

    }

}
