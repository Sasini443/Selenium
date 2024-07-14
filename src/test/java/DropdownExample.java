import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownExample {

    WebDriver driver;

    @BeforeMethod
    public void firstDropdown(){
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(1400, 1000);
        driver.manage().window().setSize(newSize);
//        driver.manage().window().maximize();


    }
    @Test
    public void  testMethod() throws InterruptedException {

        driver.get("https://leafground.com/select.xhtml");
        //   ways of select values in Basic Dropdown
        WebElement drop = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(drop);
        select.selectByIndex(2);
        Thread.sleep(3000);
        select.selectByVisibleText("Selenium");
        Thread.sleep(3000);

        //   get the number of dropdown options
//        generics
        List<WebElement> options = select.getOptions();
        int count =  options.size();
        System.out.println("size is " +count);
        for (WebElement element :options){
            System.out.println(element.getText());
        }
        //   using sendKeys select dropdown values

        drop.sendKeys("Puppeteer");

        //   Selecting values in bootstrap dropdown
           WebElement dropdown = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
           dropdown.click();
        List<WebElement>  elements = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element :elements){
            System.out.println(element.getText());
        }





    }

    @Test
    public void googleDropdown(){
        //    Google search pickup a value from suggestions
    driver.get("https://www.google.com/");
    driver.findElement(By.name("q")).sendKeys("Palitha");
        List<WebElement>  elements2  =  driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']"));
        for (WebElement element :elements2){
         String val =  element.getText();
         if (val.equals("Palitha Thewarapperuma"))
         {
             element.click();
             System.out.println("val");
             break;
         }
        }

        //    Handle Hidden Auto suggestions Drop down and search using DOM debugger trick

    }


}
