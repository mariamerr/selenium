package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static PageObject.NewTestBase.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class ItemPage {

    private WebElement item() {
        return $(By.cssSelector("#box-most-popular ul li:nth-child(1)"));
    }

    private By size = By.name("options[Size]");

    private By countOfItems = By.cssSelector("#cart .quantity");

    private WebElement selectSize() {
        return $(size);
    }

    private WebElement countOfItems() {
        return $(countOfItems);
    }

    private WebElement addToCartButton() {
        return $(By.name("add_cart_product"));
    }

    private WebElement recycleBinClick() {
        return $(By.cssSelector("#cart > a.link"));
    }

    public void addItemToRecycleBin() {
        for (int i = 1; i <= 3; i++) {
            item().click();
            if (isElementPresent(size)) {
                Select size = new Select(selectSize());
                size.selectByIndex(1);
            }
            addToCartButton().click();
            wait.until(textToBe(countOfItems, String.valueOf(i)));
            driver.get("http://litecart.stqa.ru/en/");
        }
    }

    public void goToRecycleBin() {
        recycleBinClick().click();
    }
}
