package bg.vivacom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;
    private NavigationBarPage navBar;


    @Parameters({"vivacomHomePageUrl"})
    @Test(groups = "EndToEndTest")
    public void pressingDevicesNavButtonsSequentiallyTest(@Optional("https://www.vivacom.bg/bg") String vivacomHomePageUrl) {
        driver = BrowserDriverSetup.getDriver();
        driver.get(vivacomHomePageUrl);
        homePage = new HomePage(driver);
        navBar = new NavigationBarPage(driver);

        navBar.initializeHomePageNavBar();
        homePage.clickCookiesBtn();
        navBar.clickHomePageDevicesDropDown();
        navBar.clickHomePageMobileDevices();
    }

}

