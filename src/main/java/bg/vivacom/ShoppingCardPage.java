package bg.vivacom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoppingCardPage {
    private WebDriver driver;
    private String shoppingCardUrl = "https://www.vivacom.bg/online/bg/shop/shopping-cart";
    private WebElement continueShoppingBtn;
    private WebElement totalPriceEl;
    private WebElement purchaseAsExistingClientBtn;
    private WebElement purchaseAsNewClientBtn;
    private WebElement tAndCCheckbox;

    // Filters

    // Product APPLE IPHONE 15 PLUS 128GB+ADAPTER
    private WebElement productApple15Plus128;


    public ShoppingCardPage(WebDriver driver) {
        this.driver = driver;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.continueShoppingBtn =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "/html//span[@id='shopping-cart-span']//div[@class='summarize-order-inner']" +
                                        "/div[5]/div[4]/div[@class='widget']" +
                                        "/a[@name='vivacom-cart-link-button-continue-shopping']")));

    }

    public String getExpectedShoppingCardUrl() {
        return shoppingCardUrl;
    }

    public void clickContinueShoppingBtn() {
        this.continueShoppingBtn.click();
    }


    public double getTotalSum() {
//        System.out.println(this.totalPriceEl.getText());
        String totalSumString = this.totalPriceEl.getText().replaceAll("[^\\d.лв]", "");
        totalSumString = totalSumString.replace("лв.", "");
        double totalSum = Double.parseDouble(totalSumString);
        return totalSum;
    }

    public void removeLastAddedItemFromShoppingCard() {
        WebElement lastItem = driver.findElement(By.xpath("//div[@class='js-detail-configuration']/" +
                "div[1]/form[@action='/online/bg/shop/shopping-cart/remove']/button[@class='btn-close']/em"));
        lastItem.click();
    }

    public boolean isPurchaseAsExistingClientBtnDisabled() {
        // It appears that buttons are disabled by JS and such buttons are appended classes disable-elm
        //        System.out.println(this.purchaseAsExistingClientBtn.getAttribute("class").contains("disable-elm"));
        return this.purchaseAsExistingClientBtn.getAttribute("class").contains("disable-elm");
    }

    public boolean isPurchaseAsNewClientBtnDisabled() {
        return this.purchaseAsNewClientBtn.getAttribute("class").contains("disable-elm");
    }

    public void initializePurchaseButtons() {
        this.purchaseAsExistingClientBtn = driver.findElement(By.className("js-checkout-btn"));
        this.purchaseAsNewClientBtn = driver.findElement(By.className("js-support-checkout-btn"));
    }

    public void initializeTotalSum() {
        this.totalPriceEl = driver.findElement(By.xpath("//div[@class='summarize-order-inner']" +
                "/div[4]/span[2]"));
    }

    public void clickTandCCheckbox() {
        this.tAndCCheckbox.click();
    }

    public WebElement getCheckboxTnCEl() {
        if (this.tAndCCheckbox != null) {
            return this.tAndCCheckbox;
        } else {
//            this.tAndCCheckbox = driver.findElement(By.cssSelector(".vivacom-icon.icon-box_empty"));
            this.tAndCCheckbox = driver.findElement(By.xpath("//*[@id='shopping-cart-span']/div[1]/aside/div[1]/div/div[5]/div[1]/div/label"));
            return this.tAndCCheckbox;
        }
    }

    public String getEmptyBasketText() {
        //   System.out.println(driver.findElement(By.xpath("//section[@class='col-md-8 col-sm-7 col-xs-12']//p")).getText());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement basketElTxt =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//section[@class='col-md-8 col-sm-7 col-xs-12']//p")));

        return basketElTxt.getText();
    }

    public void removeAllItemsFromShoppngCart() {
        List<WebElement> cartItems = driver.findElements(By.cssSelector(".product-wrapper"));
        for (WebElement item : cartItems) {
            WebElement removeButton = item.findElement(By.cssSelector(".btn-close"));
            removeButton.click();
        }

    }
}
