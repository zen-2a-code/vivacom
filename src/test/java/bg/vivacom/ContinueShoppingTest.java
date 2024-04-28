package bg.vivacom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = {"EndToEndTest"})
public class ContinueShoppingTest {
    private static WebDriver driver;
    private static NavigationBarPage navigationBarPage;
    private static ProductsPage productsPage;
    private static SelectedProductPage casePage;

    @BeforeClass
    public void setup(){
        driver = BrowserDriverSetup.getDriver();
        navigationBarPage = new NavigationBarPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test(priority = 1)
    public static void navigationButtonTest(){
        navigationBarPage.initializeProductPageNavBar();
        navigationBarPage.clickProductPageDeviceBtn();
        navigationBarPage.clickProductPageAccessoriesBtn();
    }

    @Test(priority = 2)
    public static void applyingFiltersTest(){
        productsPage.initializeAccessoriesFilters();
        productsPage.clickAccessoriesBrandAppleFilter();
        productsPage.clickAccessoriesPriceAbove40Filter();

    }

    @Test (priority = 3)
    public static void selectCaseToTest(){
        productsPage.clickonCase15plusFineWoven();
    }
    @Test (priority = 4)
    public static void addingCaseToShoppingCardTest(){
        casePage = new SelectedProductPage(driver);
        casePage.clickBuyButton();

    }
}
