package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class Application extends TestBase {

WebElement item = driver.findElement(By.cssSelector("#box-most-popular ul li:nth-child(1)"));
WebElement selectSize = driver.findElement(By.name("options[Size]"));
WebElement addToCartButton = driver.findElement(By.name("add_cart_product"));
WebElement countOfItems = driver.findElement(By.cssSelector("#cart .quantity"));
WebElement recycleBinClick = driver.findElement(By.cssSelector("#cart > a.link"));
WebElement table = driver.findElement(By.cssSelector(".dataTable"));
WebElement deleteItemButton = driver.findElement(By.cssSelector("remove_cart_item"));

public void addItemToRecycle() {
    for (int i = 1; i <= 3; i++) {
        item.click();
        if (selectSize.isDisplayed()) {
            Select size = new Select(selectSize);
            size.selectByIndex(1);
        }
        addToCartButton.click();
    }
}

public void waitForAdding() {
    for (int i = 1; i <= 3; i++) {
        wait.until(textToBe((By) countOfItems, String.valueOf(i)));
    }
}

public void openMainPage() {
        driver.get("http://litecart.stqa.ru/en/");
}

public void goToRecycleBin() {
        recycleBinClick.click();
}

public void deleteAllItems() {
    while (table.isDisplayed()) {
//        WebElement table = driver.findElement(By.cssSelector(".dataTable"));
        deleteItemButton.click();
        wait.until(stalenessOf(table));
        }
    }
}


