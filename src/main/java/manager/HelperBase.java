package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void pause(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickBase(By locator){
        driver.findElement(locator).click();
    }

    public void clickWait(By locator, int time){
        new WebDriverWait(driver, time)
                .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void typeBase(By locator, String text){
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public boolean isElementPresent(By locator){
        return !driver.findElements(locator).isEmpty();
    }

    public boolean isTexInElementPresent(By locator, String text, int time){
        try {
            return new WebDriverWait(driver, time)
                    .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        }catch (TimeoutException e){
            e.printStackTrace();
            System.out.println("created exception");
            return false;
        }
    }
    public boolean isElementPresentByWait(By locator, int time){
        try {
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        }catch (org.openqa.selenium.TimeoutException e){
            e.printStackTrace();
            return false;
        }

    }
}
