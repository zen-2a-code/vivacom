package bg.vivacom;

import bg.vivacom.base.BrowserDriverSetup;
import bg.vivacom.pages.HomePage;
import bg.vivacom.pages.NavigationBarPage;
import org.testng.annotations.*;

public class HomePageTest extends BrowserDriverSetup {

    @Parameters({"vivacomHomePageUrl"})
    @Test(groups = "EndToEndTest", priority = 0)
    public void pressingDevicesNavButtonsSequentiallyTest(@Optional("https://www.vivacom.bg/bg") String vivacomHomePageUrl) {
        driver.get(vivacomHomePageUrl);
        HomePage homePage = new HomePage(driver);
        NavigationBarPage navBar = new NavigationBarPage(driver);

        homePage.clickCookiesBtn();
        navBar.clickHomePageDevicesDropDown();
        navBar.clickNavBarMobileDevices();
    }

}

