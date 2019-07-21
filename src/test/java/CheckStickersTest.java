import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckStickersTest extends TestBase {

    @Before
    public void login() {
        driver.get("http://localhost/litecart/");
    }

    @Test
    public void stickerIsExist() {
        List<WebElement> ducks = driver.findElements(By.cssSelector("ul.products > li"));
        for (WebElement duck : ducks) {
            int sickerCount = duck.findElements(By.cssSelector("div.sticker")).size();
            Assert.assertEquals(1, sickerCount);
        }
    }
}
