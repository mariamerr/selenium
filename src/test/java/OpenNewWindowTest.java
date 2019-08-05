import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.time.Duration.ofSeconds;

public class OpenNewWindowTest extends TestBase {

    private WebDriverWait wait;

    @Before
    public void login() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait = new WebDriverWait(driver, ofSeconds(10));
    }

    @Test
    public void checkOpenNewWindow() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector("tr:nth-child(2) td:nth-child(5) a")).click();
        String mainWindow = driver.getWindowHandle();
        List<WebElement> newWindowsLinks = driver.findElements(By.cssSelector("form [target=_blank]"));
        for (WebElement element : newWindowsLinks) {
            element.click();
            String newWindow = wait.until(anyWindowOtherThan(mainWindow));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }

    private ExpectedCondition<String> anyWindowOtherThan(String oldWindows) {
        return driver -> {
            Set<String> handles=driver.getWindowHandles();
            handles.remove(oldWindows);
            return handles.size() > 0 ? handles.iterator().next():null;
        };
    }

}
