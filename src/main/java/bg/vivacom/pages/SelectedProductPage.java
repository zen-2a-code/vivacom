package bg.vivacom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SelectedProductPage extends BasePageObject {
    private By oneTimePaymentUnlimited300Locator = By.xpath(
            "//div[contains(@class, 'offer-container')]//h3[contains(text(), 'Unlimited 300')]" +
                    "/ancestor::div[contains(@class, 'doi-offer')]/div[@class='plan-listing-box-col-last']/div[2]" +
                    "//span[contains(@class, 'js-related-offer-cash-price-span')]");
    private By noFixedServiceBtnLocator = By.xpath("//div[@id='xSellBtnData']");
    private By buyBtnLocator = By.xpath("//div[@id='faciaDataHighResView']//button[@type='submit']");

    public SelectedProductPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnetimePaymentUnlimited300() {
        click(this.oneTimePaymentUnlimited300Locator, 20);
    }

    public void clickNoFixedService() {
        waitForElementToBeClickable(this.noFixedServiceBtnLocator, 20);
        click(this.noFixedServiceBtnLocator);
    }

    public void clickBuyButton() {
        click(this.buyBtnLocator);
    }
}
