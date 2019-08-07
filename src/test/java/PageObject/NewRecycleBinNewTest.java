package PageObject;

import org.junit.Test;

public class NewRecycleBinNewTest extends NewTestBase {

    private MainPage mainP = new MainPage();
    private RecycleBinPage recP = new RecycleBinPage();
    private ItemPage itemP = new ItemPage();

    @Test
    public void recycleBinTest() {
        mainP.openMainPage("http://litecart.stqa.ru/en/");
        itemP.addItemToRecycleBin();
        itemP.goToRecycleBin();
        recP.deleteAllItems();
    }
}



