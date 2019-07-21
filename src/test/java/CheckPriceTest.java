import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CheckPriceTest extends TestBase {

    @Before
    public void openPage() {
        driver.get("http://localhost/litecart/");
    }

    @Test
    public void priceComparison() {
        String itemNameOnMainPage = driver.findElement(By.cssSelector("#box-campaigns .name")).getText();
        WebElement oldPriceOnMainPage = driver.findElement(By.cssSelector("#box-campaigns .price-wrapper s"));
        WebElement newPriceOnMainPage = driver.findElement(By.cssSelector("#box-campaigns .price-wrapper strong"));
        String oldPriceTextOnMainPage = oldPriceOnMainPage.getText();
        String newPriceTextOnMainPage = newPriceOnMainPage.getText();
        double fontSizeOldPriceMP = Double.parseDouble(oldPriceOnMainPage
                .getCssValue("font-size")
                .replaceAll("px", ""));
        double fontSizeNewPriceMP = Double.parseDouble(newPriceOnMainPage
                .getCssValue("font-size")
                .replaceAll("px", ""));
        checkThatColorIsGray(oldPriceOnMainPage.getCssValue("color"));
        checkThatColorIsRed(newPriceOnMainPage.getCssValue("color"));
        Assert.assertTrue("Размер шрифта акционной цены меньше старой цены",
                fontSizeNewPriceMP > fontSizeOldPriceMP);
        oldPriceOnMainPage.click();
        String itemNameItemPage = driver.findElement(By.cssSelector("h1")).getText();
        WebElement oldPriceOnItemPage = driver.findElement(By.cssSelector(".price-wrapper s"));
        WebElement newPriceOnItemPage = driver.findElement(By.cssSelector(".price-wrapper strong"));
        double fontSizeOldPriceIP = Double.parseDouble(oldPriceOnItemPage
                .getCssValue("font-size")
                .replaceAll("px", ""));
        double fontSizeNewPriceIP = Double.parseDouble(newPriceOnItemPage
                .getCssValue("font-size")
                .replaceAll("px", ""));
        checkThatColorIsGray(oldPriceOnItemPage.getCssValue("color"));
        checkThatColorIsRed(newPriceOnItemPage.getCssValue("color"));
        Assert.assertTrue("Размер шрифта акционной цены меньше старой цены",
                fontSizeNewPriceIP > fontSizeOldPriceIP);
        Assert.assertEquals("Название товара не совпадает", itemNameOnMainPage, itemNameItemPage);
        Assert.assertEquals("Старая цена на странице товара не совпадает с ценой на странице товара",
                oldPriceTextOnMainPage, oldPriceOnItemPage.getText());
        Assert.assertEquals("Акционная цена на странице товара не совпадает с ценой на странице товара",
                newPriceTextOnMainPage, newPriceOnItemPage.getText());
    }


    private void checkThatColorIsGray(String color) {
        int[] rgb = rgbToInt(color);
        Assert.assertEquals(rgb[0], rgb[1]);
        Assert.assertEquals(rgb[0], rgb[2]);
    }

    private void checkThatColorIsRed(String color) {
        int[] rgb = rgbToInt(color);
        Assert.assertEquals(0, rgb[1]);
        Assert.assertEquals(0, rgb[2]);
    }

    private int[] rgbToInt(String color) {
        String[] numbers = color.replace("rgba(", "").replace(")", "").split(",");
        int[] rgb = new int[3];
        for (int i = 0; i < 3; i++) {
            rgb[i] = Integer.parseInt(numbers[i].trim());
        }
        return rgb;
    }
}



