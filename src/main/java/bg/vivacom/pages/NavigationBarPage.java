package bg.vivacom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBarPage extends BasePageObject {

    // It appears nav bar has some differences between the nav page on the main page and the nav bar on product page
    private By navBardevicesDropDownBtnLocator = By.xpath(
            "//a[contains(text(), 'Устройства') and @role='button']");
    private By navBarMobileDevicesBtnLocator = By.xpath("//a[contains(text(), 'Мобилни телефони')]");
    private By navBarAccessoriesBtnLocator = By.xpath("//a[contains(text(), 'Аксесоари')]");

    public NavigationBarPage(WebDriver driver) {
        super(driver);
    }


    public void clickHomePageDevicesDropDown() {
        click(this.navBardevicesDropDownBtnLocator);
    }

    public void clickNavBarMobileDevices() {
        click(navBarMobileDevicesBtnLocator);
    }

    public void clickNavBarPageAccessoriesBtn() {
        click(this.navBarAccessoriesBtnLocator);
    }

}
