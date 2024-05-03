package bg.vivacom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = {"EndToEndTest"})
public class Iphone15PlusTest {
    private static WebDriver driver;
    private static SelectedProductPage apple15productPage;

    @BeforeClass
    public void setup(){
        driver = BrowserDriverSetup.getDriver();
        apple15productPage = new SelectedProductPage(driver);
    }

    @Test(priority = 1)
    public void selectOneTimePaymnetUnlimited300Test(){
        apple15productPage.initializingUnlimited300();
        apple15productPage.clickOnetimePaymentUnlimited300();
    }

    @Test(priority = 2)
    public void selectNoFixServicesTest(){
        apple15productPage.clickNoFixedService();
    }

    @Test(priority = 3)
    public void clickBuyButtonTest(){
        apple15productPage.clickBuyButton();
    }

}
