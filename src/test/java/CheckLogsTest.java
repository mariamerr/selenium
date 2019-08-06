import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;

public class CheckLogsTest extends TestBase {

    @Before
    public void login() {
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
    }

    @Test
    public void checkLogs() {
        List<WebElement> items = driver.findElements(By.cssSelector(""));
        for (WebElement element : items) {
            element.click();
            for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
                System.out.println(l);
            }
        }
    }
}
