package bg.vivacom;

import bg.vivacom.base.BrowserDriverSetup;
import bg.vivacom.pages.NavigationBarPage;
import bg.vivacom.pages.ProductsPage;
import bg.vivacom.pages.SelectedProductPage;
import org.testng.annotations.Test;

@Test(groups = {"EndToEndTest"})
public class ContinueShoppingTest extends BrowserDriverSetup {
    private static ProductsPage productsPage;


    @Test(priority = 1)
    public void navigationButtonTest() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        navigationBarPage.clickHomePageDevicesDropDown();
        navigationBarPage.clickNavBarPageAccessoriesBtn();
    }

    @Test(priority = 2)
    public void applyingFiltersTest() {
        productsPage = new ProductsPage(driver);
        productsPage.clickAppleBrandFitterCheckbox();
        productsPage.clickPriceAbove40FilterCheckbox();

    }

    @Test(priority = 3)
    public  void selectCaseToTest() {
        productsPage.clickonCase15plusFineWoven();
    }

    @Test(priority = 4)
    public void addingCaseToShoppingCardTest() {
        SelectedProductPage casePage = new SelectedProductPage(driver);
        casePage.clickBuyButton();

    }
}
