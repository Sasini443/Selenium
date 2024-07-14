import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExamplle{

    WebDriver driver;

    @BeforeMethod
    public void OpenLinkpage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/link.xhtml;jsessionid=node01tcncrxipgnwyla7byg0ltaz34714381.node0");
    }
    //    take me to dashboard
    @Test
    public void LinkTests(){
        WebElement homeElement = driver.findElement(By.linkText("Go to Dashboard"));
        homeElement.click();
        driver.navigate().back();



    //Find my destination
        WebElement homeElement2 =  driver.findElement(By.partialLinkText("Find the URL without clicking me."));
        String a = homeElement2.getAttribute("href");
        System.out.println("link is " + a);

    //Am I broken link?
        WebElement homeElement3 =  driver.findElement(By.linkText("Broken?"));
        homeElement3.click();
        String title = driver.getTitle();
        if(title.contains("404")){
            System.out.println("The link is broken");

        }
        else{
            System.out.println("work corretly");
        }
        driver.navigate().back();
    //Duplicate Link
        WebElement homeElement4 = driver.findElement(By.linkText("Go to Dashboard"));
        homeElement4.click();
        driver.navigate().back();
//        Count Links
        List<WebElement> c = driver.findElements(By.tagName("a"));
       int d =  c.size();
        System.out.println("link count" + d);

//        Count Layout Links
      WebElement e = driver.findElement(By.className("layout-main-content"));
        List<WebElement> f = e.findElements(By.tagName("a"));
        System.out.println("counts is"+f.size());
    }
}
