package bg.vivacom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@Test(groups = {"EndToEndTest"})
public class SmartPhonesProcuctsTest {


    private static WebDriver driver;
    private static ProductsPage phonesProductsPage;

    @BeforeClass

    public void setup(){
        driver = BrowserDriverSetup.getDriver();
        phonesProductsPage = new ProductsPage(driver);
    }

    @Test(priority = 1)
    public void filterDevices(){

        phonesProductsPage.initializeSmartPhoneFilters();
        phonesProductsPage.clickSmartPhoneAppleBrandFitter();
        phonesProductsPage.clickSmartPhoneBlueColorFilter();
    }

    @Test(priority = 2)
    public void selectApple15Plus128(){
        phonesProductsPage.initializeProductApple15Plus128();
        phonesProductsPage.clickApple15Plus128();
    }
}
