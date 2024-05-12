package bg.vivacom;

import bg.vivacom.base.BrowserDriverSetup;
import bg.vivacom.pages.ShoppingCardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"EndToEndTest"})
public class CaseAndPhoneVerificationTest extends BrowserDriverSetup {
    private static ShoppingCardPage shoppingCardPage;


    @Test(priority = 1)
    public void verifyShoppingCardUrlTest() {
        shoppingCardPage = new ShoppingCardPage(driver);
        String expectedUrl = shoppingCardPage.getExpectedShoppingCardUrl();
        String actualUrl = shoppingCardPage.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(priority = 2)
    public void checkSumRemoveItemTest() {
        double totalSum = shoppingCardPage.getTotalSum();

        if (totalSum > 1680) {
            shoppingCardPage.removeLastAddedItemFromShoppingCard();
        }

    }

    @Test(priority = 3)
    public void checkDisableActionsWhenTCAreUncheckedTest() {
        Assert.assertTrue(shoppingCardPage.isPurchaseAsExistingClientBtnDisabled());
        Assert.assertTrue(shoppingCardPage.isPurchaseAsNewClientBtnDisabled());
    }

    @Test(priority = 4)
    public void checkboxTandCTest() {
        Assert.assertNotNull(shoppingCardPage.getCheckboxTnCEl(), "The checkbox should exist.");
        shoppingCardPage.clickTandCCheckbox();

    }

    @Test(priority = 5)
    public void removeAllItemsTest() {
        shoppingCardPage.removeAllElements();
    }

    @Test(priority = 6)
    public void checkBasketTest() {
        String actualResult = shoppingCardPage.getEmptyBasketText();
        String expectedResult = "Вижте актуалните ни оферти и изберете най-подходящата за вас. Ако искате да разгледате предходно добавени продукти, натиснете \"Вход\".";
        Assert.assertEquals(actualResult, expectedResult);
    }

}


