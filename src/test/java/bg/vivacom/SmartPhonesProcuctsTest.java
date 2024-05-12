package bg.vivacom;
import bg.vivacom.base.BrowserDriverSetup;
import bg.vivacom.pages.ProductsPage;
import org.testng.annotations.Test;


@Test(groups = {"EndToEndTest"})
public class SmartPhonesProcuctsTest extends BrowserDriverSetup {
    private static ProductsPage phonesProductsPage;

    @Test(priority = 1)
    public void filterDevices() {
        System.out.println(driver);
        phonesProductsPage = new ProductsPage(driver);
        phonesProductsPage.clickAppleBrandFitterCheckbox();
        phonesProductsPage.clickSBlueColorFilterCheckbox();
    }

    @Test(priority = 2)
    public void selectApple15Plus128() {
        phonesProductsPage.clickApple15Plus128();
    }
}
