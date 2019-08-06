import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;

public class CheckLogsTest extends TestBase {

    @Before
    public void login() {
        driver.get("http://litecart.stqa.ru/en/");
    }

    @Test
    public void checkLogs() {
        List<WebElement> items = driver.findElements(By.cssSelector("ul.products > li"));
        for (WebElement element : items) {
            element.click();
            for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
                System.out.println(l);
            }
        }
    }
}
