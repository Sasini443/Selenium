import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioboxExample {

    WebDriver driver;

    @BeforeMethod
    public void radiobtncheck(){
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(1200,1000);
        driver.manage().window().setSize(newSize);


    }
    @Test
    public void radioCheck(){
//Find the default select radio button
        driver.get("https://leafground.com/radio.xhtml");
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='j_idt87:console2']//td"));
    for(WebElement ele :elements){
   boolean val = ele.findElement(By.tagName("input")).isSelected();
   if(val){
       System.out.println(ele.findElement(By.tagName("label")).getText());
       break;
   }

}

//Select the age group(Only if not selected)
        List<WebElement> elements1 = driver.findElements(By.xpath("//div[@id='j_idt87:age']//div"));
        for(WebElement ele1 :elements){
            boolean val1 = ele1.findElement(By.tagName("input")).isSelected();
            if(val1){
//                System.out.println(ele1.findElement(By.tagName("label")).getText());
                break;
            }


        }
      driver.findElement(By.xpath("//div[@id='j_idt87:age']//div//label[@for='j_idt87:age:0']")).click();

    }
    @Test
    public void checkboxCheck(){
//        select wanted checkboxes and verifying those checkboxes status
        driver.get("https://leafground.com/checkbox.xhtml");
        List<WebElement> lists = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement ele : lists){
            if (!(ele.getText().equals("Others"))){
                ele.click();
            }
        }
        for (int i = 1; i <= lists.size(); i++) {

            boolean ch = driver.findElement(By.xpath("//table[@id='j_idt87:basic']//input["+i+"]")).isSelected();
            if (ch) {
                System.out.println(i);
            }
        }


    }
}
