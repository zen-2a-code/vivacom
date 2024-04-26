package bg.vivacom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectedProductPage {
    private WebDriver driver;

    private WebElement planSelectionUnlimited300;
    private WebElement oneTimePaymentUnlimited300;
    private WebElement noFixedServiceBtn;
    private WebElement buyBtn;

    public SelectedProductPage(WebDriver driver){
        this.driver = driver;

        this.buyBtn = driver.findElement(
                By.xpath("//div[@id='faciaDataHighResView']//button[@type='submit']"));

    }

    public  void clickUnlimted300plan(){
        this.planSelectionUnlimited300.click();
    }

    public  void clickOnetimePaymentUnlimited300(){
       this.oneTimePaymentUnlimited300.click();
    }

    public void clickNoFixedService(){
        this.noFixedServiceBtn.click();
    }

    public void clickBuyButton(){
        this.buyBtn.click();
    }

    public void initializingUnlimited300(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        this.planSelectionUnlimited300 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(
                        "//div[@id='related-offers-table-div-id']/div[4]//p[@class='plan-listing-box-col-p']")));

        this.oneTimePaymentUnlimited300 = driver.findElement(
                By.xpath("/html//div[@id='related-offers-table-div-id']/div[4]//span[@class='e-care-home-big-bill-price-digits js-related-offer-cash-price-span']"));
        this.noFixedServiceBtn = driver.findElement(By.xpath("//p[@id='newCustomerText']/span[1]"));
    }
}
