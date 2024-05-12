package bg.vivacom;

import bg.vivacom.base.BrowserDriverSetup;
import bg.vivacom.pages.ShoppingCardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"EndToEndTest"})
public class PhoneShoppingCardVerificationTest extends BrowserDriverSetup {
    private static ShoppingCardPage shoppingCardPage;


    @Test(priority = 1)
    public void verifyShoppingCardUrlTest() {
        shoppingCardPage = new ShoppingCardPage(driver);
        String expectedUrl = shoppingCardPage.getExpectedShoppingCardUrl();
        String actualUrl = shoppingCardPage.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(priority = 2)
    public void coninueshopingForShoppingCardTest(){
        shoppingCardPage.clickContinueShoppingBtn();
    }
}
