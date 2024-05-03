package bg.vivacom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Quicktest {

    @BeforeMethod
    public void startDriver() {
    }

    @Test
    private void sanityTest() {
        WebDriver driver = BrowserDriverSetup.getDriver();
        driver.get("https://www.vivacom.bg/online/bg/shop/devices/product-category-smart-mobile-phones/apple-iphone-15-plus-128gb-adapter?offer=epc_bew240105094214030522_so_pvw240404165038210468");
        WebElement acceptCookiesBtn = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        acceptCookiesBtn.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
//        WebElement productApple15Plus128 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[text()='APPLE IPHONE 15 PLUS 128GB+ADAPTER']")));
//        productApple15Plus128.click();
//        sleepSeconds(2);


        ShoppingCardPage page = new ShoppingCardPage(driver);
        SelectedProductPage ppage = new SelectedProductPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        ppage.initializingUnlimited300();
        ppage.clickOnetimePaymentUnlimited300();
        ppage.clickNoFixedService();
        ppage.clickBuyButton();
        page.clickTandCCheckbox();
        sleepSeconds(5);

        driver.close();

    }

    public static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
