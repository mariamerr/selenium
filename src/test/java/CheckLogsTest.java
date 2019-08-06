import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntry;

public class CheckLogsTest extends TestBase {

    @Before
    public void login() {
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=2");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void checkLogs() {
        int ducksCount = driver.findElements(By.xpath("//table[@class='dataTable']//img/../a")).size();
        for (int i = 0; i < ducksCount; i++) {
            driver.findElements(By.xpath("//table[@class='dataTable']//img/../a")).get(i).click();
            for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
                System.out.println(l);
            }
            driver.navigate().back();
        }
    }

}

