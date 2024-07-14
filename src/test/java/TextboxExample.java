import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextboxExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenLinkpage(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("126");
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://leafground.com/input.xhtml");
    }
    @Test
    public void TestBoxes(){
//        Type your name
        driver.findElement(By.id("j_idt88:name")).sendKeys("Sasini");
//        Append Country to this City.
        driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("Sri Lanka");
//        Verify if text box is disabled
      boolean checkbtn =  driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
      if(!checkbtn){
          System.out.println("disabled");
      }
      else {
          System.out.println("enabled");
      }
//        Clear the typed text.
       WebElement cleartext = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
      cleartext.clear();


//        Retrieve the typed text.
      WebElement gettext = driver.findElement(By.id("j_idt88:j_idt97"));
        System.out.println(gettext.getAttribute("value"));
//        Type email and Tab. Confirm control moved to next element.
//        Type about yourself
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("sasini@gmail.com" + Keys.TAB);
    }

}
