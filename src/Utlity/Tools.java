package Utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Tools {
    public static void Bekle(int saniye) {

        try {
            Thread.sleep(1000 * saniye); // ms beklediği için 1000 ile çarpıyoruz
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
}
    public static void successMessageValidation() {
        WebElement msgLabel=BaseDriver.driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(msgLabel.getText().toLowerCase().contains("success"));
    }
}
