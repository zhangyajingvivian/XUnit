package selenium.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.page.App;
import selenium.page.ContactPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-11-25 9:48 PM
 */
public class TestWeWork {
    public static App app;

    @BeforeClass
    public static void beforeAll() {
        app = new App();
        app.loginWithCookie();
    }

    @Test
    public void add() throws InterruptedException {
        Thread.sleep(1000);
        String phone = "17721174561";
        app.toMemberAdd().add(phone, phone, phone);
    }
    @Test
    public void delete() throws InterruptedException {
        Thread.sleep(1000);
        String phone = "17721174562";
        app.toMemberAdd().add(phone, phone, phone).delete(phone);
    }

    @Test
    public void deleteCurrentPage() throws InterruptedException {
        Thread.sleep(1000);
        app.toContact().deleteCurrentPage();
    }

    @Test
    public void importFormFile() throws InterruptedException {
        Thread.sleep(1000);
        app.toContact().importFromFile("/Users/zhangyajing/Downloads/通讯录批量导入模板.xlsx");
    }

    @AfterClass
    public static void afterAll() throws InterruptedException {
        app.quit();
    }
}
