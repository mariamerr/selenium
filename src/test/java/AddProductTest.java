import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class AddProductTest extends TestBase {

    @Before
    public void login() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void addProduct() {
        driver.findElement(By.cssSelector("li#app-:nth-child(2)")).click();
        driver.findElement(By.cssSelector("a.button:nth-child(2)")).click();
        driver.findElement(By.name("status")).click();
        driver.findElement(By.name("name[en]")).sendKeys("Toy1");
        driver.findElement(By.name("code")).sendKeys("13");
        driver.findElement(By.xpath("//td[text()='Unisex']/..//input")).click();
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("10");
        String imgPath = System.getProperty("user.dir") + "/images/1.jpg";
        driver.findElement(By.cssSelector("input[type=file]")).sendKeys(imgPath);
        driver.findElement(By.name("date_valid_from")).sendKeys("01.07.2019");
        driver.findElement(By.name("date_valid_to")).sendKeys("01.10.2019");
        driver.findElement(By.cssSelector("#content li:nth-child(2) > a")).click();
        Select manufacture = new Select(driver.findElement(By.name("manufacturer_id")));
        manufacture.selectByIndex(1);
        driver.findElement(By.name("keywords")).sendKeys("Toy, Birthday, Party");
        driver.findElement(By.name("short_description[en]")).sendKeys("Toy for everyone");
        driver.findElement(By.name("description[en]")).sendKeys("This is description");
        driver.findElement(By.name("head_title[en]")).sendKeys("Super toy");
        driver.findElement(By.name("meta_description[en]")).sendKeys("This is meta description");
        driver.findElement(By.cssSelector("#content li:nth-child(4) > a")).click();
        driver.findElement(By.name("purchase_price")).clear();
        driver.findElement(By.name("purchase_price")).sendKeys("300,00");
        Select currency = new Select(driver.findElement(By.name("purchase_price_currency_code")));
        currency.selectByIndex(1);
        driver.findElement(By.name("prices[USD]")).clear();
        driver.findElement(By.name("prices[USD]")).sendKeys("300,00");
        driver.findElement(By.name("prices[EUR]")).clear();
        driver.findElement(By.name("prices[EUR]")).sendKeys("300,00");
        driver.findElement(By.name("save")).click();
        driver.findElement(By.xpath(("//a[contains(text(),'Toy1')]")));
    }
}
