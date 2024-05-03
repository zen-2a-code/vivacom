package bg.vivacom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectedProductPage {
    private WebDriver driver;
    private WebElement oneTimePaymentUnlimited300;
    private WebElement noFixedServiceBtn;
    private WebElement buyBtn;

    public SelectedProductPage(WebDriver driver){
        this.driver = driver;

        this.buyBtn = driver.findElement(
                By.xpath("//div[@id='faciaDataHighResView']//button[@type='submit']"));

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
        this.oneTimePaymentUnlimited300 = driver.findElement(
                By.xpath("//div[starts-with(@id,'relatedOfferDiv-epc_be')]//span[@class='e-care-home" +
                        "-big-bill-price-digits js-related-offer-cash-price-span']"));
        this.noFixedServiceBtn = driver.findElement(By.xpath("//div[@id='xSellBtnData']"));
    }
}
