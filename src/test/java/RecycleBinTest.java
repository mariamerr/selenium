import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class RecycleBinTest extends TestBase {


    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    WebDriver driver = new ChromeDriver();

//    private WebDriverWait wait;
//    wait = new WebDriverWait(driver, ofSeconds(10));


    @Before
    public void login() {
        driver.get("http://litecart.stqa.ru/en/");
    }

    @Test
    public void addToRecycle() {
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.cssSelector("#box-most-popular ul li:nth-child(1)")).click();
            String beforeAdd = driver.findElement(By.cssSelector("#cart > a.content")).getText();
            driver.findElement(By.name("add_cart_product")).click();
            String afterAdd = driver.findElement(By.cssSelector("#cart > a.content")).getText();
            Assert.assertNotEquals(beforeAdd, afterAdd);
            driver.get("http://litecart.stqa.ru/en/");
        }
        driver.findElement(By.cssSelector("#cart > a.link")).click();
            for (int i = 0; i < 3; i++) {
                String totalPrice = driver.findElement(By.cssSelector("#cart > a.content")).getText();
                driver.findElement(By.name("remove_cart_item")).click();
                String priceAfterRemove = driver.findElement(By.cssSelector(".footer > td:nth-child(2)")).getText();
                Assert.assertNotEquals(totalPrice, priceAfterRemove);
            }
    }
}
