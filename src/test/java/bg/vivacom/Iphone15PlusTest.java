package bg.vivacom;

import bg.vivacom.base.BrowserDriverSetup;
import bg.vivacom.pages.SelectedProductPage;
import org.testng.annotations.Test;

@Test(groups = {"EndToEndTest"})
public class Iphone15PlusTest extends BrowserDriverSetup {
    private static SelectedProductPage apple15productPage;

    @Test(priority = 1)
    public void selectOneTimePaymnetUnlimited300Test() {
        apple15productPage = new SelectedProductPage(driver);
        apple15productPage.clickOnetimePaymentUnlimited300();
    }

    @Test(priority = 2)
    public void selectNoFixServicesTest() {
        apple15productPage.clickNoFixedService();
    }

    @Test(priority = 3)
    public void clickBuyButtonTest() {
        apple15productPage.clickBuyButton();
    }

}
