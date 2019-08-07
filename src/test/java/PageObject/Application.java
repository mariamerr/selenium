package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class Application extends TestBase {

    public WebDriverWait wait;
    public WebDriver driver;

    public void addItemToRecycle() {
        for (int i = 1; i <= 3; i++) {
            driver.findElement(By.cssSelector("#box-most-popular ul li:nth-child(1)")).click();
            if (isElementPresent(By.name("options[Size]"))) {
                Select size = new Select(driver.findElement(By.name("options[Size]")));
                size.selectByIndex(1);
            }
            driver.findElement(By.name("add_cart_product")).click();
        }
    }

    public void waitForAdding() {
        for (int i = 1; i <= 3; i++) {
            wait.until(textToBe(By.cssSelector("#cart .quantity"), String.valueOf(i)));
        }
    }

    public void openMainPage() {
        driver.get("http://litecart.stqa.ru/en/");
    }

    public void goToRecycleBin() {
        driver.findElement(By.cssSelector("#cart > a.link")).click();
    }

    public void deleteAllItems() {
        while (isElementPresent(By.cssSelector(".dataTable"))) {
            WebElement table = driver.findElement(By.cssSelector(".dataTable"));
            driver.findElement(By.name("remove_cart_item")).click();
            wait.until(stalenessOf(table));
        }
    }
}


