import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    public class LoginTest {

        private WebDriver driver;

        @Before
        public void start() {
            driver = new ChromeDriver();
        }

        @Test
        public void myloginTest() {
            driver.get("https://http://localhost/litecart/admin/");
            driver.findElement(By.name("email")).sendKeys("test@mail.com");
            driver.findElement(By.name("password")).sendKeys("qwerty");
            driver.findElement(By.name("login")).click();
        }

        @After
        public void stop() {
            driver.quit();
            driver = null;
        }
    }
}
