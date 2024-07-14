import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionmouseExamplle {

    WebDriver driver;

    @BeforeMethod
    public void radiobtncheck(){
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(1200,1000);
        driver.manage().window().setSize(newSize);



    }
    @Test
    public void mouseOperationsTest1(){
        driver.get("https://leafground.com/drag.xhtml;jsessionid=node01dg4c7nq8zphfjjd4bgfrd2t04932225.node0");
        System.out.println("move to an element operation");
       Actions actions = new Actions(driver);
        WebElement x = driver.findElement(By.id("menuform:j_idt37"));
       actions.moveToElement(x);

    }

    @Test
    public void mouseOperationsTest2(){

    }
}
