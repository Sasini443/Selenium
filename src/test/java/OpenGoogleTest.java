import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class OpenGoogleTest {

    @Test
    public  void googleTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement usernameField = driver.findElement(By.name("user-name"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));

        String username = "standard_user";
        String password = "secret_sauce";

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            WebElement dashboardElement = driver.findElement(By.id("inventory_container"));
            System.out.println("Login successful");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Login failed");
        } finally {

            driver.quit();
        }


    }

}
