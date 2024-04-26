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
    public void selectUnlimited300Test(){
        apple15productPage.initializingUnlimited300();
        apple15productPage.clickUnlimted300plan();
    }

    @Test(priority = 2)
    public void selectOneTimePaymnetTest(){
        apple15productPage.clickOnetimePaymentUnlimited300();
    }

    @Test(priority = 3)
    public void selectNoFixServicesTest(){
        apple15productPage.clickNoFixedService();
    }

    @Test(priority = 4)
    public void clickBuyButtonTest(){
        apple15productPage.clickBuyButton();
    }

}
