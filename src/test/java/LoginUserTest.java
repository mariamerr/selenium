import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class LoginUserTest extends TestBase {

    @Before
    public void openPage() {
        driver.get("http://localhost/litecart/");
    }

    @Test
    public void loginUser() {
        driver.findElement(By.cssSelector(".box tbody a")).click();
        driver.findElement(By.name("firstname")).sendKeys("Ivan");
        driver.findElement(By.name("lastname")).sendKeys("Petrov");
        driver.findElement(By.name("address1")).sendKeys("New Street, 28");
        driver.findElement(By.name("postcode")).sendKeys("12345");
        driver.findElement(By.name("city")).sendKeys("New York");
        Select countries = new Select(driver.findElement(By.name("country_code")));
        countries.selectByVisibleText("United States");
        driver.findElement(By.name("zone_code")).sendKeys("Alabama");
        long email = System.currentTimeMillis();
        driver.findElement(By.name("email")).sendKeys(email + "@gmail.ru");
        driver.findElement(By.name("phone")).sendKeys("+70001234567");
        driver.findElement(By.name("password")).sendKeys("qwerty123");
        driver.findElement(By.name("confirmed_password")).sendKeys("qwerty123");
        driver.findElement(By.name("create_account")).click();
        driver.findElement(By.cssSelector("#box-account :nth-child(4) a")).click();
        driver.findElement(By.name("email")).sendKeys(email + "@gmail.ru");
        driver.findElement(By.name("password")).sendKeys("qwerty123");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.cssSelector("#box-account :nth-child(4) a")).click();
    }
}
