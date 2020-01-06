package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverAction;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;

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

    public ContactPage toEditDepartment(String ... departmentNames) throws InterruptedException {
        String id="";
        for(String departmentName : departmentNames) {
            WebElement department = findElement(By.linkText(departmentName));
            id = findElement(By.linkText(departmentName)).getAttribute("id");
            department.click();
            department.click();
        }
        findElement(By.xpath("//a[@id='"+ id + "']/span")).click();
        return this;
    }

    public ContactPage addDepartment(String departmentName) {
        findElement(By.xpath("//ul[@class='vakata-context jstree-contextmenu jstree-default-contextmenu']/li[1]")).click();
        findElement(By.name("name")).sendKeys(departmentName);
        findElement(By.linkText("确定")).click();
        return this;
    }

    public ContactPage deleteDepartment(String departmentName) {
        findElement(By.xpath("//ul[@class='vakata-context jstree-contextmenu jstree-default-contextmenu']/li[7]")).click();
        findElement(By.linkText("确定")).click();
        return this;
    }

    public ContactPage moveUpDepartment() throws InterruptedException {
        findElement(By.xpath("//ul[@class='vakata-context jstree-contextmenu jstree-default-contextmenu']/li[9]")).click();
        return this;
    }

    public ContactPage moveDownDepartment() throws InterruptedException {
        findElement(By.xpath("//ul[@class='vakata-context jstree-contextmenu jstree-default-contextmenu']/li[11]")).click();
        return this;
    }
}
