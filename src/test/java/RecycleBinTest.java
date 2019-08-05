import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class RecycleBinTest extends TestBase {

   private WebDriverWait wait;

    @Before
    public void login() {
        driver.get("http://litecart.stqa.ru/en/");
        wait = new WebDriverWait(driver, ofSeconds(10));
    }

    @Test
    public void addToRecycle() {
        for (int i = 1; i <= 3; i++) {
            driver.findElement(By.cssSelector("#box-most-popular ul li:nth-child(1)")).click();
            if (isElementPresent(By.name("options[Size]"))) {
                Select size = new Select(driver.findElement(By.name("options[Size]")));
                size.selectByIndex(1);
            }
            driver.findElement(By.name("add_cart_product")).click();
            wait.until(textToBe(By.cssSelector("#cart .quantity"), String.valueOf(i)));
            driver.get("http://litecart.stqa.ru/en/");
        }
        driver.findElement(By.cssSelector("#cart > a.link")).click();
        while (isElementPresent(By.cssSelector(".dataTable"))) {
            WebElement table = driver.findElement(By.cssSelector(".dataTable"));
            driver.findElement(By.name("remove_cart_item")).click();
            wait.until(stalenessOf(table));
        }
    }
}
