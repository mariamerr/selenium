package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static PageObject.NewTestBase.$;
import static PageObject.NewTestBase.isElementPresent;
import static PageObject.NewTestBase.wait;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class RecycleBinPage {

    private By table = By.cssSelector(".dataTable");

    private WebElement table() {
        return $(table);
    }

    private WebElement deleteItemButton() {
        return $(By.name("remove_cart_item"));
    }

    public void deleteAllItems() {
        while (isElementPresent(table)) {
            deleteItemButton().click();
            wait.until(stalenessOf(table()));
        }
    }
}
