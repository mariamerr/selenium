package PageObject;

import org.junit.Test;

public class NewRecycleBinTest extends TestBase {

    private Application app;

    @Test
    public void recycleBinTest() {
        app.openMainPage();
        app.addItemToRecycle();
        app.waitForAdding();
        app.goToRecycleBin();
        app.deleteAllItems();
    }
}



