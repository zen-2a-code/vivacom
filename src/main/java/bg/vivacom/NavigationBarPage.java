package bg.vivacom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationBarPage {
    private WebDriver driver;

    // It appears nav bar has some differences between the nav page on the main page and the nav bar on product page
    private WebElement homePagedevicesDropDownBtn;
    private WebElement homeMobileDevicesBtn;

    private WebElement productPageDevicesDropdownBtn;
    private WebElement productPageAccessoriesBtn;

    public NavigationBarPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickHomePageDevicesDropDown() {this.homePagedevicesDropDownBtn.click();}

    public void clickHomePageMobileDevices() {
        this.homeMobileDevicesBtn.click();
    }

    public void clickProductPageAccessoriesBtn() {
        this.productPageAccessoriesBtn.click();
    }

    public void clickProductPageDeviceBtn() {
        this.productPageDevicesDropdownBtn.click();
    }

    public void initializeHomePageNavBar() {
        this.homePagedevicesDropDownBtn = driver.findElement(By.xpath("//li[2]/a[@role='button']"));
        this.homeMobileDevicesBtn = driver.findElement(By.cssSelector("li:nth-of-type(2) > " +
                ".dropdown-menu.mega-menu > li:nth-of-type(1) > div > .dropdown-link-text > a"));

    }

    public void initializeProductPageNavBar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        this.productPageDevicesDropdownBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(
                        "//li[@id='vivacom-devices-navbar']/a[@role='button']")));

        this.productPageAccessoriesBtn =
                driver.findElement((By.xpath("//li[@id='vivacom-devices-navbar']" +
                        "/ul[@class='dropdown-menu mega-menu']/li[@class='mega-menu-main-part']/ul/div[6]" +
                        "//a[@href='/online/bg/shop/devices/listing?navigation=product-category-accessories']")));
    }
}
