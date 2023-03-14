package TestProje3;

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.util.resources.ms.CalendarData_ms_MY;

import java.time.Duration;

public class Proje3 extends BaseDriver {

    By aranilanFrame = By.xpath("//*[@class='EJIframeV3 EJOverlayV3']");


    @Test(priority = 1)
    void Test1() {
        driver.get("https://shopdemo.e-junkie.com/");
        WebElement ebook = driver.findElement(By.xpath("//*[text()='Ebook']"));
        ebook.click();
        WebElement addToCart = driver.findElement(By.xpath("//*[@class='view_product']"));
        addToCart.click();
        WebElement frame1 = driver.findElement(aranilanFrame);
        driver.switchTo().frame(frame1);
        Tools.Bekle(3);
        WebElement promoCode = driver.findElement(By.xpath("//*[text()='Add Promo Code']"));
        promoCode.click();
        WebElement promoCodeTxt = driver.findElement(By.xpath("//*[@class='Promo-Code-Value']"));
        promoCodeTxt.sendKeys("asdasdasdasd");
        WebElement promoCodeApply = driver.findElement(By.xpath("//button[@class='Promo-Apply']"));
        promoCodeApply.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='SnackBar']")));
        WebElement alert = driver.findElement(By.xpath("//*[@id='SnackBar']"));
        Assert.assertTrue(alert.isDisplayed(), "Başarışız oldu");
    }

    @Test(priority = 2)
    void Test2() {
        driver.get("https://shopdemo.e-junkie.com/");
        WebElement ebook = driver.findElement(By.xpath("//*[text()='Ebook']"));
        ebook.click();
        WebElement addToCart = driver.findElement(By.xpath("//*[@class='view_product']"));
        addToCart.click();
        WebElement frame1 = driver.findElement(aranilanFrame);
        driver.switchTo().frame(frame1);
        Tools.Bekle(2);
        WebElement debit = driver.findElement(By.xpath("//*[text()='                                    Pay using Debit / Credit Card                                    ']"));
        debit.click();
        WebElement payBtn = driver.findElement(By.xpath("//*[text()='Pay 0.50 USD']"));
        payBtn.click();
        WebElement invalidMail = driver.findElement(By.xpath("//*[text()='Invalid Email']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='Invalid Email']")));
        Assert.assertTrue(invalidMail.isDisplayed(), "Başarısız oldu");

    }

    @Test(priority = 3)
    void Test3(){
        driver.get("https://shopdemo.e-junkie.com/");
        WebElement ebook = driver.findElement(By.xpath("//*[text()='Ebook']"));
        ebook.click();
        WebElement addToCart = driver.findElement(By.xpath("//*[@class='view_product']"));
        addToCart.click();
        WebElement frame1 = driver.findElement(aranilanFrame);
        driver.switchTo().frame(frame1);
        Tools.Bekle(2);
        WebElement debit = driver.findElement(By.xpath("//*[text()='                                    Pay using Debit / Credit Card                                    ']"));
        debit.click();
        //driver.switchTo().defaultContent();
        //Tools.Bekle(2);
        WebElement frame2= driver.findElement(By.xpath("//iframe[@title='Secure card payment input frame']"));
        driver.switchTo().frame(frame2);
        Tools.Bekle(2);
        WebElement cardNumber=driver.findElement(By.xpath("//*[@name='cardnumber']"));
        cardNumber.sendKeys("1111 1111 1111 1111");
        driver.switchTo().parentFrame();
        Tools.Bekle(2);
        WebElement alert= driver.findElement(By.xpath("//span[text()='Your card number is invalid.']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='Your card number is invalid.']")));
        Assert.assertTrue(alert.isDisplayed(),"Kart numarası başarılı");


    }
    @Test(priority = 4)
    void Test4(){

        driver.get("https://shopdemo.e-junkie.com/");
        String ilkUrl=driver.getCurrentUrl();
        WebElement ebook = driver.findElement(By.xpath("//*[text()='Ebook']"));
        ebook.click();
        WebElement addToCart = driver.findElement(By.xpath("//*[@class='view_product']"));
        addToCart.click();
        WebElement frame1 = driver.findElement(aranilanFrame);
        driver.switchTo().frame(frame1);
        Tools.Bekle(2);
        WebElement debit = driver.findElement(By.xpath("//*[text()='                                    Pay using Debit / Credit Card                                    ']"));
        debit.click();
        WebElement email = driver.findElement(By.xpath("//input[@placeholder ='Email']"));
        email.sendKeys("asdasdasda@gmail.com");
        WebElement confirmEmail = driver.findElement(By.xpath("//input[@placeholder ='Confirm Email']"));
        confirmEmail.sendKeys("asdasdasda@gmail.com");
        WebElement phone = driver.findElement(By.xpath("//*[@class ='Billing-Phone Inline']/input"));
        phone.sendKeys("05555555555");
        WebElement name= driver.findElement(By.xpath("//*[@placeholder='Name On Card']"));
        name.sendKeys("Alperen");
        WebElement company = driver.findElement(By.xpath("//*[@class ='Billing-Company']/input"));
        company.sendKeys("Techno Study");
        WebElement frame2= driver.findElement(By.xpath("//iframe[@title='Secure card payment input frame']"));
        driver.switchTo().frame(frame2);
        Tools.Bekle(2);
        WebElement cardNumber=driver.findElement(By.xpath("//*[@name='cardnumber']"));
        cardNumber.sendKeys("4242 4242 4242 4242");
        WebElement mm=driver.findElement(By.xpath("//*[@placeholder='MM / YY']"));
        mm.sendKeys("03 25");
        WebElement cvc=driver.findElement(By.xpath("//*[@name='cvc']"));
        cvc.sendKeys("123");
        driver.switchTo().parentFrame();
        Tools.Bekle(2);
        WebElement payBtn= driver.findElement(By.xpath("//*[@class='Pay-Button']"));
        payBtn.click();
        Tools.Bekle(15);
        //WebElement loadingBtn= driver.findElement(By.xpath("//img[@alt='Loading']"));
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.invisibilityOf(loadingBtn));
        //Tools.Bekle(5);
        WebElement confrimMessage= driver.findElement(By.xpath("//span[@class='green_text_margin']"));
        Assert.assertTrue(confrimMessage.isDisplayed(),"Başarısız oldu");
    }
    @Test(priority = 5)
    void Test5(){
        driver.get("https://shopdemo.e-junkie.com/");
        WebElement contact= driver.findElement(By.xpath("//*[@class='contact']"));
        contact.click();
        WebElement name= driver.findElement(By.xpath("//input[@id='sender_name']"));
        name.sendKeys("Tolunay");
        WebElement email= driver.findElement(By.xpath("//input[@id='sender_email']"));
        email.sendKeys("asdasdasda@gmail.com");
        WebElement subject= driver.findElement(By.xpath("//input[@id='sender_subject']"));
        subject.sendKeys("Frameleri sevmiyoruz");
        WebElement message= driver.findElement(By.xpath("//*[@id='sender_message']"));
        message.sendKeys("Techno Study 5");
        // WebElement frame5= driver.findElement(By.xpath("//*[@title='reCAPTCHA']"));
        // driver.switchTo().frame(frame5);
        // WebElement iamRobot= driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-checkmark']"));
        // iamRobot.click();
        // driver.switchTo().defaultContent();

        WebElement messageBtn= driver.findElement(By.xpath("//*[@id='send_message_button']"));
        messageBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert=driver.switchTo().alert().getText();
        Assert.assertTrue(alert.contains("Recaptcha didn't match"),"Başarısız oldu");
        driver.switchTo().alert().accept();

    }
}
