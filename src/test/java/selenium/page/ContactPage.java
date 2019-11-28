package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-11-25 10:16 PM
 */
public class ContactPage extends BasePage{

    public ContactPage add(String username, String id, String phone) {
        findElement(By.name("username")).sendKeys(username);
        findElement(By.name("acctid")).sendKeys(id);
        findElement(By.name("mobile")).sendKeys(phone);
        findElement(By.linkText("保存")).click();
        return this;
    }

    public ContactPage delete(String keyWord) {
        findElement(By.id("memberSearchInput")).sendKeys(keyWord);
        if (findElement(By.cssSelector(".js_del_member")) != null) {
            findElement(By.cssSelector(".js_del_member")).click();
            findElement(By.linkText("确认")).click();
        } else {
            findElement(By.id("clearMemberSearchInput")).click();
        }
        return this;
    }

    public ContactPage deleteCurrentPage() {
        waitClickable(By.cssSelector(".ww_checkbox"), 10);
        List<WebElement> checkboxs = driver.findElements(By.cssSelector(".ww_checkbox"));
        for (int i = 1; i < checkboxs.size(); i++) {
            checkboxs.get(i).click();
        }
        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();
        return this;
    }

    public ContactPage importFromFile(String path) {
        findElement(By.partialLinkText("批量导入")).click();
        findElement(By.linkText("文件导入")).click();
        findElement(By.id("js_upload_file_input")).sendKeys(path);
        findElement(By.id("submit_csv")).click();
        findElement(By.id("reloadContact")).click();
        return this;
    }

    public void list() {

    }
}
