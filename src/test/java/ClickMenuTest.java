import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ClickMenuTest {

    private WebDriver driver;

    @Before
    public void login() {
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @Test
    public void myClickMenuTest() {
        int mainListSize = driver.findElements(By.cssSelector("li#app-")).size();
        for (int i = 1; i <= mainListSize; i++) {
            driver.findElement(By.cssSelector("li#app-:nth-child(" + i + ")")).click();
            driver.findElement(By.cssSelector("h1"));
            int subListSize = driver.findElements(By.cssSelector(".docs > li")).size();
            for (int j = 1; j <= subListSize; j++) {
                driver.findElement(By.cssSelector(".docs > li:nth-child(" + j + ")")).click();
                driver.findElement(By.cssSelector("h1"));
            }
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
