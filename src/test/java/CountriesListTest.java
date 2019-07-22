import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CountriesListTest extends TestBase {

    @Before
    public void login() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void checkCountriesSort() {
        List<WebElement> listOfCountries = driver.findElements(By.cssSelector("td:nth-child(5) > a"));
        List<String> countries = new ArrayList<>();
        for (WebElement element : listOfCountries) {
            countries.add(element.getAttribute("textContent"));
        }
        List<String> beforeSort = new ArrayList<>(countries);
        Collections.sort(countries);
        Assert.assertEquals(countries, beforeSort);
    }

    @Test
    public void checkZonesInCountries() {
        List<WebElement> countries = driver.findElements(By.xpath("//tr[@class='row']/td[6][text()!='0']"));
        int listSize = countries.size();
        for (int i = 0; i < listSize; i++) {
            driver.findElements(By.xpath("//tr[@class='row']/td[6][text()!='0']")).get(i)
                    .findElement(By.xpath("..//a[@title='Edit']")).click();
            List<WebElement> listOfZones = driver.findElements(By.xpath("//*[@id='table-zones']//td[3][text()]"));
            List<String> zones = new ArrayList<>();
            for (WebElement element : listOfZones) {
                zones.add(element.getAttribute("textContent"));
            }
            List<String> beforeSort = new ArrayList<>(zones);
            Collections.sort(zones);
            Assert.assertEquals(zones, beforeSort);
            driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        }
    }

    @Test
    public void checkZones() {
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        List<WebElement> countries = driver.findElements(By.xpath("//tr[@class='row']/td[3]/a"));
        int listSize = countries.size();
        for (int i = 0; i < listSize; i++) {
            driver.findElements(By.xpath("//tr[@class='row']/td[3]/a")).get(i).click();
            List<WebElement> listOfZones = driver.findElements(By.cssSelector("#table-zones td:nth-child(3) option[selected]"));
            List<String> zones = new ArrayList<>();
            for (WebElement element : listOfZones) {
                zones.add(element.getAttribute("textContent"));
            }
            List<String> beforeSort = new ArrayList<>(zones);
            Collections.sort(zones);
            Assert.assertEquals(zones, beforeSort);
            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        }
    }
}