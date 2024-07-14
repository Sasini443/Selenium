import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Windowexample {


    WebDriver driver;

    @BeforeMethod
    public void radiobtncheck(){
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(1200,1000);
        driver.manage().window().setSize(newSize);
        driver.get("https://leafground.com/window.xhtml");


    }
    @Test
    public void windowsTest() throws InterruptedException {
//        click and confirm new window open
      String a = driver.getWindowHandle();
        System.out.println("Parent window is "+ a);
        driver.findElement(By.id("j_idt88:new")).click();
        Thread.sleep(3000);
        Set<String> b = driver.getWindowHandles();
        //        using foreach loop
//        for (String ele: b){
//            System.out.println(ele);
//            driver.switchTo().window(ele);
//            System.out.println("Title is"+ driver.getTitle());
//        }
//        driver.close();
//        driver.switchTo().window(a);
//       String val = driver.findElement(By.id("j_idt88:new")).getText();
//        System.out.println(val);
//        if(driver.findElement(By.id("j_idt88:new")).isDisplayed()){
//            System.out.println("correct page");
//        }

//        list
        List<String> list = new ArrayList<String>(b);
        if (list.size()>1){
            driver.switchTo().window(list.get(1));
            System.out.println("child is "+ driver.getTitle());
            driver.close();
            driver.switchTo().window(a);

        }
        String vals = driver.findElement(By.id("j_idt88:new")).getText();
        System.out.println(vals);
        if(driver.findElement(By.id("j_idt88:new")).isDisplayed()){
            System.out.println("correct page");
        }


//        find the number of opened tabs
        driver.findElement(By.id("j_idt88:j_idt91")).click();
        Set<String> abc =  driver.getWindowHandles();
        System.out.println(abc.size());
//        close open windows except primary
        driver.findElement(By.id("j_idt88:j_idt93")).click();
        Set<String> abcd =  driver.getWindowHandles();
        for (String valss: abcd){
            if(!(valss.equals(a))){
                driver.switchTo().window(valss);
                driver.close();
            }
        }
    }

}
