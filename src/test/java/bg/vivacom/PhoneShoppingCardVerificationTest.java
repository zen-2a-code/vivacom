package bg.vivacom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = {"EndToEndTest"})
public class PhoneShoppingCardVerificationTest {
    private static WebDriver driver;
    private static ShoppingCardPage shoppingCardPage;

    @BeforeClass
    public void setup() {
        driver = BrowserDriverSetup.getDriver();
        shoppingCardPage = new ShoppingCardPage(driver);
    }

    @Test(priority = 1)
    public void verifyShoppingCardUrlTest() {
        String expectedUrl = shoppingCardPage.getExpectedShoppingCardUrl();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(priority = 2)
    public void coninueshopingForShoppingCardTest(){
        shoppingCardPage.clickContinueShoppingBtn();
    }
}
