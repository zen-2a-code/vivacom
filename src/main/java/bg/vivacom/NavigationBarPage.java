package bg.vivacom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationBarPage {
    private WebDriver driver;

    // It appears nav bar has some differences between the nav page on the main page and the nav bar on product page
    private WebElement navBardevicesDropDownBtn;
    private WebElement navBarMobileDevicesBtn;
    private WebElement navBarAccessoriesBtn;

    public NavigationBarPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickHomePageDevicesDropDown() {
        this.navBardevicesDropDownBtn.click();
    }

    public void clickNavBarMobileDevices() {
        this.navBarMobileDevicesBtn.click();
    }

    public void clickNavBarPageAccessoriesBtn() {
        this.navBarAccessoriesBtn.click();
    }


    public void initializeNavBarBtns() {
        this.navBardevicesDropDownBtn = driver.findElement(By.xpath(
                "//a[contains(text(), 'Устройства') and @role='button']"));
        this.navBarMobileDevicesBtn = driver.findElement(By.xpath(
                "//a[contains(text(), 'Мобилни телефони')]"));
        this.navBarAccessoriesBtn =
                driver.findElement((By.xpath("//a[contains(text(), 'Аксесоари')]")));
    }

}
