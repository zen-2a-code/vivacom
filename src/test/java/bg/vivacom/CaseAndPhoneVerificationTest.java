package bg.vivacom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@Test(groups = {"EndToEndTest"})
public class CaseAndPhoneVerificationTest {
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
    public void checkSumRemoveItemTest() {
        shoppingCardPage.initializeTotalSum();
        double totalSum = shoppingCardPage.getTotalSum();

        if (totalSum > 1680) {
            shoppingCardPage.removeLastAddedItemFromShoppingCard();
        }

    }

    @Test(priority = 3)
    public void checkDisableActionsWhenTCAreUncheckedTest() {
        shoppingCardPage.initializePurchaseButtons();
        Assert.assertTrue(shoppingCardPage.isPurchaseAsExistingClientBtnDisabled());
        Assert.assertTrue(shoppingCardPage.isPurchaseAsNewClientBtnDisabled());
    }

    @Test(priority = 4)
    public void checkboxTandCTest() {
        shoppingCardPage = new ShoppingCardPage(driver);
        Assert.assertNotNull(shoppingCardPage.getCheckboxTnCEl(), "The checkbox should exist.");
        shoppingCardPage.clickTandCCheckbox();

    }

    @Test(priority = 5)
    public void removeAllItemsTest() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted while sleeping");
        }
        shoppingCardPage.removeLastAddedItemFromShoppingCard();
    }

    @Test(priority = 6)
    public void checkBasketTest() {
        String actualResult = shoppingCardPage.getEmptyBasketText();
        String expectedResult = "Вижте актуалните ни оферти и изберете най-подходящата за вас. Ако искате да разгледате предходно добавени продукти, натиснете \"Вход\".";
        Assert.assertEquals(actualResult,expectedResult);
    }

}


