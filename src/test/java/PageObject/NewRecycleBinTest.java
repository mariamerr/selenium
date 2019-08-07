package PageObject;

import org.junit.Test;

public class NewRecycleBinTest extends TestBase {

    public static Application app;

    @Test
    public void recycleBinTest() {
        app.openMainPage();
        app.addItemToRecycle();
        app.waitForAdding();
        app.goToRecycleBin();
        app.deleteAllItems();
    }
}



