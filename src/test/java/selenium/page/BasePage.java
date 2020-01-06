package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-11-25 11:39 PM
 */
public class BasePage {
    public static WebDriver driver;

    public WebElement findElement(By by) {
        return findElement(by, 5);
    }

    public WebElement findElement(By by, int timeout) {
        System.out.println(by);
        if (timeout > 0) {
            waitClickable(by, timeout);
        }
        try {
            return driver.findElement(by);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<WebElement> findElements(By by) {
        return findElements(by, 5);
    }

    public List<WebElement> findElements(By by, int timeout) {
        if (timeout > 0) {
            waitClickables(by, timeout);
        }
        try {
            return driver.findElements(by);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void waitClickable(By by, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitClickable(By by) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(by));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitClickables(By by, int timeout) {
//        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void quit() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
