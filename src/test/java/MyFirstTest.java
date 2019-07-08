import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myFirstTest() {
        driver.get("https://ru.wikipedia.org/");
        driver.findElement(By.name("search")).sendKeys("Тест");
        driver.findElement(By.name("go")).click();
        wait.until(ExpectedConditions.titleIs("Тест"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

