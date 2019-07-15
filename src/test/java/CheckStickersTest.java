import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class CheckStickersTest extends TestBase {

    @Before
    public void login() {
        driver.get("http://localhost/litecart/");
    }

    @Test
    public void stickerIsExist() {
        int ducksCount = driver.findElements(By.cssSelector("ul.products > li")).size();
        for (int i = 1; i <= ducksCount; i++) {
            driver.findElement(By.cssSelector("div.sticker"));
        }
    }
}
