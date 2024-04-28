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


    // Product APPLE IPHONE 15 PLUS 128GB+ADAPTER
    private WebElement productApple15Plus128;


    public ShoppingCardPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getExpectedShoppingCardUrl() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(this.shoppingCardUrl));
        return shoppingCardUrl;
    }

    public void clickContinueShoppingBtn() {
        if (this.continueShoppingBtn == null) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            this.continueShoppingBtn =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.xpath(
                                    "/html//span[@id='shopping-cart-span']//div[@class='summarize-order-inner']" +
                                            "/div[5]/div[4]/div[@class='widget']" + "/a[@name='vivacom-cart-link-button-continue-shopping']")));
        }

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
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        WebElement lastItem = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
//                "//button[@class='btn-close'][@type='submit']"))));
//        lastItem.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        By closeButton = By.xpath("//button[@class='btn-close'][@type='submit']");
        wait.until(ExpectedConditions.presenceOfElementLocated(closeButton));
        WebElement lastItem = wait.until(ExpectedConditions.elementToBeClickable(closeButton));
        lastItem.click();
    }

    public void removeAllElements() {
        List<WebElement> allItems = driver.findElements(By.xpath(
                "//button[@class='btn-close'][@type='submit']"));

        // Not sure why I need to put the Thread to sleep. Tried with diffrent wait conditions - none worked. I will be
        // Happy to receive feedback of the correct method.

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted while sleeping");
        }

        for (WebElement item : allItems) {
            this.removeLastAddedItemFromShoppingCard();
        }
    }

    public boolean isPurchaseAsExistingClientBtnDisabled() {
        // It appears that buttons are disabled by JS and such buttons are appended classes disable-elm

//        System.out.println(this.purchaseAsExistingClientBtn.getAttribute("class").contains("disable-elm"));
        return this.purchaseAsExistingClientBtn.getAttribute("class").contains("disable-elm");
    }

    public boolean isPurchaseAsNewClientBtnDisabled() {
//        System.out.println(this.purchaseAsNewClientBtn.getAttribute("class").contains("disable-elm"));
        return this.purchaseAsNewClientBtn.getAttribute("class").contains("disable-elm");
    }

    public void initializePurchaseButtons() {
        this.purchaseAsExistingClientBtn = driver.findElement(By.xpath(
                "//div[@data-position='CartLinkButtonCheckoutCustomer']/div/button"));
        this.purchaseAsNewClientBtn = driver.findElement(By.xpath(
                "//div[@data-position='CartLinkButtonCheckoutSupport']//button"));
    }

    public void initializeTotalSum() {
        this.totalPriceEl = driver.findElement(By.xpath("//div[@class='summarize-order-inner']" +
                "/div[4]/span[2]"));
    }

    public void clickTandCCheckbox() {
        getCheckboxTnCEl();
        this.tAndCCheckbox.click();
    }

    public WebElement getCheckboxTnCEl() {
        if (this.tAndCCheckbox != null) {
            return this.tAndCCheckbox;
        } else {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
            this.tAndCCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shopping-cart-span']/div[1]/aside/div[1]/div/div[5]/div[1]/div/label")));
            return this.tAndCCheckbox;
        }
    }

    public String getEmptyBasketText() {
        //   System.out.println(driver.findElement(By.xpath("//section[@class='col-md-8 col-sm-7 col-xs-12']//p")).getText());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement basketElTxt =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='empty-shopping-cart']/p")));

        return basketElTxt.getText();
    }

}
